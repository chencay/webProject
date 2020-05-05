package com.ycx.web.mongo.entity;

import com.ycx.web.mysql.entity.IdEntity;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author ycx
 * @description 用户信息和角色信息关联表
 * @date 2020/5/1 2:29 下午
 **/
public class UserRole {

    /** id **/
    @Id
    private String id;
    /** 用户id **/
    private Long userId;
    /** 角色id **/
    private Long roleId;

    /**
     * getId
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * setId
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getUserId
     * @return Long
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * setUserId
     * @param userId userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * getRoleId
     * @return Long
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * setRoleId
     * @param roleId roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
