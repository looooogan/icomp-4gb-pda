package com.icomp.Iswtmv10.v01c01.c01s008;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.apiclient.constants.OperationEnum;
import com.apiclient.pojo.SynthesisCuttingToolBind;
import com.apiclient.pojo.SynthesisCuttingToolConfig;
import com.apiclient.pojo.SynthesisCuttingToolLocationConfig;
import com.apiclient.vo.SynthesisCuttingToolInitVO;
import com.icomp.Iswtmv10.R;
import com.icomp.Iswtmv10.internet.IRequest;
import com.icomp.Iswtmv10.internet.MyCallBack;
import com.icomp.Iswtmv10.internet.RetrofitSingle;
import com.icomp.common.activity.CommonActivity;
import com.icomp.common.activity.ExceptionProcessCallBack;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具拆分
 */
public class C01S008_001Activity extends CommonActivity {

    @BindView(R.id.tvScan)
    TextView mTvScan;
    @BindView(R.id.btnCancel)
    Button mBtnCancel;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.activity_c01s008_001)
    LinearLayout activityC01s008001;


    //扫描线程
    private scanThread scanThread;

    private Retrofit retrofit;

    SynthesisCuttingToolBind synthesisCuttingToolBind;
    // 合成刀标签
    String synthesisCuttingToolBindRFID = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c01s008_001);
        ButterKnife.bind(this);

        //调用接口
        retrofit = RetrofitSingle.newInstance();

    }

    @OnClick({R.id.tvScan, R.id.btnCancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvScan:
                scan();
                break;
            case R.id.btnCancel:
                finish();
                break;
            default:
        }
    }

//    //重写键盘上扫描按键的方法
//    @Override
//    protected void btnScan() {
//        super.btnScan();
//        if (isCanScan) {
//            isCanScan = false;
//        } else {
//            return;
//        }
//        scan();
//    }


    /**
     * 开始扫描
     */
    private void scan() {
        if (rfidWithUHF.startInventoryTag((byte) 0, (byte) 0)) {
            isCanScan = false;
            mTvScan.setClickable(false);
            mBtnCancel.setClickable(false);
            //显示扫描弹框的方法
            scanPopupWindow();
            //扫描线程
            scanThread = new scanThread();
            scanThread.start();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.initFail), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 扫描线程,将扫描结果进行网络请求
     */
    private class scanThread extends Thread {
        @Override
        public void run() {
            super.run();
            //单扫方法
            rfidString = singleScan();//TODO 生产环境需要
//            rfidString = "18000A00000D3F3C";// TODO 生产环境需要删除
            if ("close".equals(rfidString)) {
                mTvScan.setClickable(true);
                mBtnCancel.setClickable(true);
                isCanScan = true;
                Message message = new Message();
                overtimeHandler.sendMessage(message);
            } else if (null != rfidString) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvScan.setClickable(true);
                        mBtnCancel.setClickable(true);
                        isCanScan = true;

                        if (null != popupWindow && popupWindow.isShowing()) {
                            popupWindow.dismiss();
                        }

                        loading.show();
                    }
                });

                try {
                    //调用接口，查询合成刀具组成信息
                    IRequest iRequest = retrofit.create(IRequest.class);

                    SynthesisCuttingToolInitVO synthesisCuttingToolInitVO = new SynthesisCuttingToolInitVO();
                    synthesisCuttingToolInitVO.setRfidCode(rfidString);

                    String jsonStr = objectToJson(synthesisCuttingToolInitVO);
                    RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonStr);

                    Map<String, String> headsMap = new HashMap<>();
                    headsMap.put("impower", OperationEnum.SynthesisCuttingTool_UnConfig.getKey().toString());

                    Call<String> getBind = iRequest.getBind(body, headsMap);
                    getBind.enqueue(new MyCallBack<String>() {
                        @Override
                        public void _onResponse(Response<String> response) {
                            try {
                                String inpower = response.headers().get("impower");

                                if (response.raw().code() == 200) {
                                    synthesisCuttingToolBind = jsonToObject(response.body(), SynthesisCuttingToolBind.class);
                                    synthesisCuttingToolBindRFID = rfidString;

                                    if (synthesisCuttingToolBind != null) {
                                        setTextViewHandler(inpower);
//                                    Message message = new Message();
//                                    message.obj = inpower;
//                                    scanHandler.sendMessage(message);
                                    } else {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(getApplicationContext(), getString(R.string.queryNoMessage), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                } else {
                                    final String errorStr = response.errorBody().string();
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            createAlertDialog(C01S008_001Activity.this, errorStr, Toast.LENGTH_LONG);
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), getString(R.string.dataError), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } finally {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (null != loading && loading.isShowing()) {
                                            loading.dismiss();
                                        }
                                    }
                                });
                            }
                        }

                        @Override
                        public void _onFailure(Throwable t) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (null != loading && loading.isShowing()) {
                                        loading.dismiss();
                                    }
                                    createAlertDialog(C01S008_001Activity.this, getString(R.string.netConnection), Toast.LENGTH_LONG);
                                }
                            });
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (null != loading && loading.isShowing()) {
                                loading.dismiss();
                            }
                            Toast.makeText(getApplicationContext(), getString(R.string.dataError), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }
    }



    public void setTextViewHandler(String inpower) {
        try {
            Map<String, String> inpowerMap = jsonToObject(inpower, Map.class);

            // 判断是否显示提示框
            if ("1".equals(inpowerMap.get("type"))) {
                // 是否需要授权 true为需要授权；false为不需要授权
                is_need_authorization = false;

                // 用于页面之间传值，新方法
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("synthesisCuttingToolBind", synthesisCuttingToolBind);
                paramMap.put("synthesisCuttingToolBindRFID", synthesisCuttingToolBindRFID);
                PARAM_MAP.put(1, paramMap);


                //跳转到库存盘点刀具信息详细页面
                Intent intent = new Intent(C01S008_001Activity.this, c01s008_002Activity.class);
                // 不清空页面之间传递的值
                intent.putExtra("isClearParamMap", false);
                startActivity(intent);
                finish();
            } else if ("2".equals(inpowerMap.get("type"))) {
                is_need_authorization = true;
                exceptionProcessShowDialogAlert(inpowerMap.get("message"), new ExceptionProcessCallBack() {
                    @Override
                    public void confirm() {
                        // 用于页面之间传值，新方法
                        Map<String, Object> paramMap = new HashMap<>();
                        paramMap.put("synthesisCuttingToolBind", synthesisCuttingToolBind);
                        paramMap.put("synthesisCuttingToolBindRFID", synthesisCuttingToolBindRFID);
                        PARAM_MAP.put(1, paramMap);


                        //跳转到库存盘点刀具信息详细页面
                        Intent intent = new Intent(C01S008_001Activity.this, c01s008_002Activity.class);
                        // 不清空页面之间传递的值
                        intent.putExtra("isClearParamMap", false);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void cancel() {
                        // 不做任何操作
                    }
                });
            } else if ("3".equals(inpowerMap.get("type"))) {
                is_need_authorization = false;
                stopProcessShowDialogAlert(inpowerMap.get("message"), new ExceptionProcessCallBack() {
                    @Override
                    public void confirm() {
                        finish();
                    }

                    @Override
                    public void cancel() {
                        // 实际上没有用
                        finish();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (null != loading && loading.isShowing()) {
                        loading.dismiss();
                    }
                    Toast.makeText(getApplicationContext(), getString(R.string.dataError), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



//    //扫描Handler
//    @SuppressLint("HandlerLeak")
//    Handler scanHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            String inpower = msg.obj.toString();
//
//            ObjectMapper mapper = new ObjectMapper();
//            Map<String, String> inpowerMap = new HashMap<>();
//            try {
//                inpowerMap = mapper.readValue(inpower, Map.class);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // 判断是否显示提示框
//            if ("1".equals(inpowerMap.get("type"))) {
//                // 是否需要授权 true为需要授权；false为不需要授权
//                is_need_authorization = false;
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //跳转到库存盘点刀具信息详细页面
//                        Intent intent = new Intent(C01S008_001Activity.this, c01s008_002Activity.class);
//                        intent.putExtra(PARAM, synthesisCuttingToolBind);
//                        intent.putExtra("synthesisCuttingToolBindRFID", synthesisCuttingToolBindRFID);
//                        startActivity(intent);
//                        finish();
//                    }
//                });
//
//            } else if ("2".equals(inpowerMap.get("type"))) {
//                is_need_authorization = true;
//                exceptionProcessShowDialogAlert(inpowerMap.get("message"), new ExceptionProcessCallBack() {
//                    @Override
//                    public void confirm() {
//                        //跳转到库存盘点刀具信息详细页面
//                        Intent intent = new Intent(C01S008_001Activity.this, c01s008_002Activity.class);
//                        intent.putExtra(PARAM, synthesisCuttingToolBind);
//                        intent.putExtra("synthesisCuttingToolBindRFID", synthesisCuttingToolBindRFID);
//                        startActivity(intent);
//                        finish();
//                    }
//
//                    @Override
//                    public void cancel() {
//                        // 不做任何操作
//                    }
//                });
//            } else if ("3".equals(inpowerMap.get("type"))) {
//                is_need_authorization = false;
//                stopProcessShowDialogAlert(inpowerMap.get("message"), new ExceptionProcessCallBack() {
//                    @Override
//                    public void confirm() {
//                        finish();
//                    }
//
//                    @Override
//                    public void cancel() {
//                        // 实际上没有用
//                        finish();
//                    }
//                });
//            }
//        }
//    };



    private void search(SynthesisCuttingToolConfig synthesisCuttingToolConfig) {
        try {
            List<SynthesisCuttingToolLocationConfig> synthesisCuttingToolLocationConfigList = synthesisCuttingToolConfig.getSynthesisCuttingToolLocationConfigList();

            for (SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig : synthesisCuttingToolLocationConfigList) {
                Log.e("code", synthesisCuttingToolLocationConfig.getCuttingTool().getCode());
            }

            SynthesisCuttingToolInitVO synthesisCuttingToolInitVO = new SynthesisCuttingToolInitVO();
            synthesisCuttingToolInitVO.setSynthesisCode(synthesisCuttingToolConfig.getSynthesisCuttingToolCode());

            //调用接口，查询合成刀具组成信息
            IRequest iRequest = retrofit.create(IRequest.class);

            String jsonStr = objectToJson(synthesisCuttingToolInitVO);
            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonStr);

            Call<String> getBind = iRequest.getBind(body, new HashMap<String, String>());
            getBind.enqueue(new MyCallBack<String>() {
                @Override
                public void _onResponse(Response<String> response) {
                    try {
                        if (response.raw().code() == 200) {
                            SynthesisCuttingToolConfig synthesisCuttingToolConfig = jsonToObject(response.body(), SynthesisCuttingToolConfig.class);

                            Log.e("synthesisCutting", synthesisCuttingToolConfig.toString());
                        } else {
                            final String errorStr = response.errorBody().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    createAlertDialog(C01S008_001Activity.this, errorStr, Toast.LENGTH_LONG);
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (null != loading && loading.isShowing()) {
                                    loading.dismiss();
                                }
                            }
                        });
                    }
                }

                @Override
                public void _onFailure(Throwable t) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (null != loading && loading.isShowing()) {
                                loading.dismiss();
                            }
                            createAlertDialog(C01S008_001Activity.this, getString(R.string.netConnection), Toast.LENGTH_LONG);
                        }
                    });

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (null != loading && loading.isShowing()) {
                        loading.dismiss();
                    }
                    Toast.makeText(getApplicationContext(), getString(R.string.dataError), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
