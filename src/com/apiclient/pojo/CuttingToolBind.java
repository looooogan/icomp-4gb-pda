package com.apiclient.pojo;

import java.io.Serializable;

/**
* Created by jiangchenkeji
* Automated Build
* 实体 CuttingToolBind 
*/
public class CuttingToolBind implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    /**
     * @fieldName id
    * @fieldType  Integer
    * @Description  id
     */
    private Integer id;

    /**
     * @fieldName code
    * @fieldType  String
    * @Description  编码
     */
    private String code;
    /**
     * @fieldName cuttingToolCode
    * @fieldType  String
    * @Description  材料刀编号
     */
    private String cuttingToolCode;
    /**
     * @fieldName rfidContainerCode
    * @fieldType  String
    * @Description  RIFD编码
     */
    private String rfidContainerCode;
    /**
     * @fieldName bladeCode
    * @fieldType  String
    * @Description  刀身码
     */
    private String bladeCode;
    /**
     * @fieldName rfidCode
    * @fieldType  String
    * @Description  
     */
    private String rfidCode;
    /**
     * @fieldName isDel
    * @fieldType  Integer
    * @Description  逻辑删除
     */
    private Integer isDel;
    /**
     * @fieldName jgcs
    * @fieldType  Integer
    * @Description  刀上线一次实际加工几个件
     */
    private Integer jgcs;
    /**
     * @fieldName lhcs
    * @fieldType  Integer
    * @Description  生成后第一次领用数值为1，刃磨一次数量+1
     */
    private Integer lhcs;
    /**
     * @fieldName sharpenTimes
    * @fieldType  Integer
    * @Description  刃磨次数
     */
    private Integer sharpenTimes;
    /**
     * @fieldName qimingSharpenTimes
    * @fieldType  Integer
    * @Description  启明刃磨次数 两次 场外涂层 
     */
    private Integer qimingSharpenTimes;
    /**
     * @fieldName scapCase
    * @fieldType  String
    * @Description  报废原因
     */
    private String scapCase;
    /**
     * @fieldName scapStatus
    * @fieldType  String
    * @Description  报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
     */
    private String scapStatus;
    /**
     * @fieldName lltm
    * @fieldType  String
    * @Description  领料条码CK
     */
    private String lltm;
    /**
     * @fieldName jgsm
    * @fieldType  Integer
    * @Description  标准成本加工寿命，单次加工寿命
     */
    private Integer jgsm;
    /**
     * @fieldName uninCode
    * @fieldType  String
    * @Description  后加的刀具唯一码
     */
    private String uninCode;
    /**
     * @fieldName inUser
    * @fieldType  String
    * @Description  是否使用 1是 0 否
     */
    private String inUser;
    /**
     * @fieldName processingCount
    * @fieldType  Integer
    * @Description  累计加工量
     */
    private Integer processingCount;

    /**
     * @fieldName cuttingToolCode
    * @fieldType  
    * @Description  材料刀编号
     */
    private CuttingTool cuttingTool;
    /**
     * @fieldName rfidContainerCode
    * @fieldType  
    * @Description  RIFD编码
     */
    private RfidContainer rfidContainer;



    /* id */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCuttingToolCode() {
        return cuttingToolCode;
    }

    public void setCuttingToolCode(String cuttingToolCode) {
        this.cuttingToolCode = cuttingToolCode;
    }
    public String getRfidContainerCode() {
        return rfidContainerCode;
    }

    public void setRfidContainerCode(String rfidContainerCode) {
        this.rfidContainerCode = rfidContainerCode;
    }
    public String getBladeCode() {
        return bladeCode;
    }

    public void setBladeCode(String bladeCode) {
        this.bladeCode = bladeCode;
    }
    public String getRfidCode() {
        return rfidCode;
    }

    public void setRfidCode(String rfidCode) {
        this.rfidCode = rfidCode;
    }
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
    public Integer getJgcs() {
        return jgcs;
    }

    public void setJgcs(Integer jgcs) {
        this.jgcs = jgcs;
    }
    public Integer getLhcs() {
        return lhcs;
    }

    public void setLhcs(Integer lhcs) {
        this.lhcs = lhcs;
    }
    public Integer getSharpenTimes() {
        return sharpenTimes;
    }

    public void setSharpenTimes(Integer sharpenTimes) {
        this.sharpenTimes = sharpenTimes;
    }
    public Integer getQimingSharpenTimes() {
        return qimingSharpenTimes;
    }

    public void setQimingSharpenTimes(Integer qimingSharpenTimes) {
        this.qimingSharpenTimes = qimingSharpenTimes;
    }
    public String getScapCase() {
        return scapCase;
    }

    public void setScapCase(String scapCase) {
        this.scapCase = scapCase;
    }
    public String getScapStatus() {
        return scapStatus;
    }

    public void setScapStatus(String scapStatus) {
        this.scapStatus = scapStatus;
    }
    public String getLltm() {
        return lltm;
    }

    public void setLltm(String lltm) {
        this.lltm = lltm;
    }
    public Integer getJgsm() {
        return jgsm;
    }

    public void setJgsm(Integer jgsm) {
        this.jgsm = jgsm;
    }
    public String getUninCode() {
        return uninCode;
    }

    public void setUninCode(String uninCode) {
        this.uninCode = uninCode;
    }
    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }
    public Integer getProcessingCount() {
        return processingCount;
    }

    public void setProcessingCount(Integer processingCount) {
        this.processingCount = processingCount;
    }

    public CuttingTool getCuttingTool() {
        return cuttingTool;
    }

    public void setCuttingTool(CuttingTool cuttingTool) {
        this.cuttingTool = cuttingTool;
    }
    public RfidContainer getRfidContainer() {
        return rfidContainer;
    }

    public void setRfidContainer(RfidContainer rfidContainer) {
        this.rfidContainer = rfidContainer;
    }


}
