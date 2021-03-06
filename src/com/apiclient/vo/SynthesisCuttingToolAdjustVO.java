package com.apiclient.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* Created by jiangchenkeji
* Automated Build
* 实体 SynthesisCuttingToolAdjustVO 
*/
public class SynthesisCuttingToolAdjustVO implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    /**
     * @fieldName id
    * @fieldType  Integer
    * @Description  调刀记录id
     */
    private Integer id;


    /**
     * @fieldName synthesisCode
    * @fieldType  String
    * @Description  合成刀业务编码
     */
    private String synthesisCode;

    /**
     * @fieldName businessCode
    * @fieldType  String
    * @Description  材料号
     */
    private String businessCode;

    /**
     * @fieldName productLineCode
    * @fieldType  String
    * @Description  生产关联关系code
     */
    private String productLineCode;

    /**
     * @fieldName processName
    * @fieldType  String
    * @Description  工序名称
     */
    private String processName;

    /**
     * @fieldName processCode
    * @fieldType  String
    * @Description  工序编码
     */
    private String processCode;

    /**
     * @fieldName equipmentName
    * @fieldType  String
    * @Description  设备名称
     */
    private String equipmentName;

    /**
     * @fieldName equipmentCode
    * @fieldType  String
    * @Description  设备编码
     */
    private String equipmentCode;

    /**
     * @fieldName axleCode
    * @fieldType  String
    * @Description  轴编码
     */
    private String axleCode;

    /**
     * @fieldName axleName
    * @fieldType  String
    * @Description  轴名称
     */
    private String axleName;

    /**
     * @fieldName partsName
    * @fieldType  String
    * @Description  零部件名称
     */
    private String partsName;

    /**
     * @fieldName partsCode
    * @fieldType  String
    * @Description  零件编码
     */
    private String partsCode;

    /**
     * @fieldName adjustCustomerCode
    * @fieldType  String
    * @Description  调到人编码
     */
    private String adjustCustomerCode;

    /**
     * @fieldName adjustCustomerName
    * @fieldType  String
    * @Description  调刀人姓名
     */
    private String adjustCustomerName;

    /**
     * @fieldName adjustTime
    * @fieldType  Timestamp
    * @Description  调刀时间 开始时间
     */
    private Timestamp adjustTimeBegin;
    /**
     * @fieldName adjustTime
    * @fieldType  Timestamp
    * @Description  调刀时间 结束时间
     */
    private Timestamp adjustTimeEnd;
    /**
     * @fieldName adjustTime
    * @fieldType  Timestamp
    * @Description  调刀时间
     */
    private Timestamp adjustTime;

    /**
     * @fieldName synthesisCuttingToolCode
    * @fieldType  String
    * @Description  合成刀code
     */
    private String synthesisCuttingToolCode;

    /**
     * @fieldName cuttingToolCode
    * @fieldType  String
    * @Description  材料刀编码
     */
    private String cuttingToolCode;

    /**
     * @fieldName assemblylineCode
    * @fieldType  String
    * @Description  流水线code
     */
    private String assemblylineCode;

    /**
     * @fieldName assemblylineName
    * @fieldType  String
    * @Description  流水线名称
     */
    private String assemblylineName;

    /**
     * @fieldName isDel
    * @fieldType  Integer
    * @Description  逻辑删除
     */
    private Integer isDel;



    /**
     * @fieldName currentPage
    * @fieldType  Integer
    * @Description  当前页码
     */
    private Integer currentPage = 1;

    /**
     * @fieldName totalPage
    * @fieldType  Integer
    * @Description  总页数
     */
    private Integer totalPage;

    /**
     * @fieldName pageSize
    * @fieldType  Integer
    * @Description  每页记录条数
     */
    private Integer pageSize = 10;

    /**
     * @fieldName maxPage
    * @fieldType  Integer
    * @Description  总页数
     */
    private Integer maxPage;

    /**
     * @fieldName startRecord
    * @fieldType  Integer
    * @Description  开始查询记录
     */
    private Integer startRecord;


    /* 调刀记录id */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSynthesisCode() {
        return synthesisCode;
    }

    public void setSynthesisCode(String synthesisCode) {
        this.synthesisCode = synthesisCode;
    }
    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }
    public String getProductLineCode() {
        return productLineCode;
    }

    public void setProductLineCode(String productLineCode) {
        this.productLineCode = productLineCode;
    }
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }
    public String getAxleCode() {
        return axleCode;
    }

    public void setAxleCode(String axleCode) {
        this.axleCode = axleCode;
    }
    public String getAxleName() {
        return axleName;
    }

    public void setAxleName(String axleName) {
        this.axleName = axleName;
    }
    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }
    public String getPartsCode() {
        return partsCode;
    }

    public void setPartsCode(String partsCode) {
        this.partsCode = partsCode;
    }
    public String getAdjustCustomerCode() {
        return adjustCustomerCode;
    }

    public void setAdjustCustomerCode(String adjustCustomerCode) {
        this.adjustCustomerCode = adjustCustomerCode;
    }
    public String getAdjustCustomerName() {
        return adjustCustomerName;
    }

    public void setAdjustCustomerName(String adjustCustomerName) {
        this.adjustCustomerName = adjustCustomerName;
    }
    public Timestamp getAdjustTimeBegin() {
        return adjustTimeBegin;
    }

    public void setAdjustTimeBegin(Timestamp adjustTimeBegin) {
        this.adjustTimeBegin = adjustTimeBegin;
    }

    public Timestamp getAdjustTimeEnd() {
        return adjustTimeEnd;
    }

    public void setAdjustTimeEnd(Timestamp adjustTimeEnd) {
        this.adjustTimeEnd = adjustTimeEnd;
    }
    public Timestamp getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Timestamp adjustTime) {
        this.adjustTime = adjustTime;
    }
    public String getSynthesisCuttingToolCode() {
        return synthesisCuttingToolCode;
    }

    public void setSynthesisCuttingToolCode(String synthesisCuttingToolCode) {
        this.synthesisCuttingToolCode = synthesisCuttingToolCode;
    }
    public String getCuttingToolCode() {
        return cuttingToolCode;
    }

    public void setCuttingToolCode(String cuttingToolCode) {
        this.cuttingToolCode = cuttingToolCode;
    }
    public String getAssemblylineCode() {
        return assemblylineCode;
    }

    public void setAssemblylineCode(String assemblylineCode) {
        this.assemblylineCode = assemblylineCode;
    }
    public String getAssemblylineName() {
        return assemblylineName;
    }

    public void setAssemblylineName(String assemblylineName) {
        this.assemblylineName = assemblylineName;
    }
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }



    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        this.startRecord = (this.currentPage-1)*pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        this.maxPage = this.totalPage/this.pageSize+(this.totalPage%this.pageSize)>0?1:0;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Integer startRecord) {
        this.startRecord = startRecord;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }



}
