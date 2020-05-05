package com.ycx.web.mongo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ycx
 * @description 日期时间相关字段
 * @date 2020/5/5 8:31 下午
 **/
public class DateTimeEntity {
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
