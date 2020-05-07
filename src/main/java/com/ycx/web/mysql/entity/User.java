package com.ycx.web.mysql.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ycx.web.mongo.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ycx
 * @description 简单的用户信息
 * @date 2020/4/25 8:59 下午
 **/
@Entity
public class User extends ExpandEntity{

    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;
    /** 当前用户的电话 **/
    private String telephone;
    /** 当前用户的地址 **/
    private String address;
    /** 当前账户是否可用 **/
    private boolean enabled;
    /** 当前账户是否未锁定 **/
    private boolean locked;
    /** 角色 **/
    private String roles;

    /**
     * setUsername
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * setPassword
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getTelephone
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * setTelephone
     * @param telephone telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * getAddress
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * setAddress
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * setEnabled
     * @param enabled enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * isLocked
     * @return boolean
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * setLocked
     * @param locked locked
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * getRoles
     * @return List<Role>
     */
    public String getRoles() {
        return roles;
    }

    /**
     * setRoles
     * @param roles roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
