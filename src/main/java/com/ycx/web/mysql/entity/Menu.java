package com.ycx.web.mysql.entity;


import org.springframework.data.annotation.Id;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @author ycx
 * @description 资源表，用于动态配置权限、返回vue数据
 * @date 2020/5/1 4:47 下午
 **/
@Entity
public class Menu extends IdEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 用户能访问的url **/
    private String url;
    /** vue路由的path **/
    private String path;
    /** vue对应的component **/
    private String component;
    /**是否认证 **/
    private int requireAuth;
    /** 父组件id **/
    private int parentId;
    /** 状态 **/
    private int status;
    /** 角色 **/
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Role> roles;

    /**
     * getUrl
     * @return String
     */
    public String getUrl() {
        return url;
    }

    /**
     * setUrl
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * getPath
     * @return String
     */
    public String getPath() {
        return path;
    }

    /**
     * setPath
     * @param path path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * getComponent
     * @return String
     */
    public String getComponent() {
        return component;
    }

    /**
     * setComponent
     * @param component component
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * getRequireAuth
     * @return int
     */
    public int getRequireAuth() {
        return requireAuth;
    }

    /**
     * setRequireAuth
     * @param requireAuth requireAuth
     */
    public void setRequireAuth(int requireAuth) {
        this.requireAuth = requireAuth;
    }

    /**
     * getParentId
     * @return int
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * setParentId
     * @param parentId parentId
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * getStatus
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * setStatus
     * @param status status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * getRoles
     * @return List<Role>
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * setRoles
     * @param roles roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
