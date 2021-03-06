package com.apiclient.vo;

import java.io.Serializable;

/**
* Created by jiangchenkeji
* Automated Build
* 实体 PowerPositionHasGroupVO 
*/
public class PowerPositionHasGroupVO implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    /**
     * @fieldName id
    * @fieldType  Integer
    * @Description  标识
     */
    private Integer id;


    /**
     * @fieldName authPositionCode
    * @fieldType  Integer
    * @Description  
     */
    private Integer authPositionCode;

    /**
     * @fieldName powerGroupCode
    * @fieldType  Integer
    * @Description  
     */
    private Integer powerGroupCode;

    /**
     * @fieldName isDel
    * @fieldType  Integer
    * @Description  
     */
    private Integer isDel;

    /**
     * @fieldName authPositionCode
    * @fieldType  
    * @Description  
     */
    private AuthPositionVO authPositionVO;
    /**
     * @fieldName powerGroupCode
    * @fieldType  
    * @Description  
     */
    private PowerGroupVO powerGroupVO;


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


    /* 标识 */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthPositionCode() {
        return authPositionCode;
    }

    public void setAuthPositionCode(Integer authPositionCode) {
        this.authPositionCode = authPositionCode;
    }
    public Integer getPowerGroupCode() {
        return powerGroupCode;
    }

    public void setPowerGroupCode(Integer powerGroupCode) {
        this.powerGroupCode = powerGroupCode;
    }
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public AuthPositionVO getAuthPositionVO() {
        return authPositionVO;
    }

    public void setAuthPositionVO(AuthPositionVO authPositionVO) {
        this.authPositionVO = authPositionVO;
    }
    public PowerGroupVO getPowerGroupVO() {
        return powerGroupVO;
    }

    public void setPowerGroupVO(PowerGroupVO powerGroupVO) {
        this.powerGroupVO = powerGroupVO;
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
