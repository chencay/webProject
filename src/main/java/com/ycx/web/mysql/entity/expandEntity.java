package com.ycx.web.mysql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ycx
 * @description 创建人、修改人、创建时间、修改时间
 * @date 2020/4/25 10:08 下午
 **/
public abstract class expandEntity extends IdEntity{

    /** 年月日格式 **/
    private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    /** 创造人 **/
    protected String creatorName;
    /** 创造时间 **/
    protected Date createTime = new Date();
    /** 修改人 **/
    protected String modifierName;
    /** 修改时间 **/
    protected Date modifyTime;

    /**
     * getCreatorName
     * @return String
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * setCreatorName
     * @param creatorName creatorName
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * getCreateTime
     * @return Date
     */
    @JsonFormat(pattern = TIME_FORMAT, timezone = "GMT+08:00")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * setCreateTime
     * @param createTime createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * getModifierName
     * @return String
     */
    public String getModifierName() {
        return modifierName;
    }

    /**
     * setModifierName
     * @param modifierName modifierName
     */
    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    /**
     * getModifyTime
     * @return Date
     */
    @JsonFormat(pattern = TIME_FORMAT, timezone = "GMT+08:00")
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * setModifyTime
     * @param modifyTime modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
