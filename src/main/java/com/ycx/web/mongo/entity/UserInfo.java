package com.ycx.web.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ycx
 * @description 用户信息
 * @date 2020/5/5 8:26 下午
 **/
public class UserInfo extends DateTimeEntity implements Serializable, UserDetails {

    /** id **/
    @Id
    private String id;
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
    private List<Role> roles;

    /**
     * getId
     * @return id
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roles.size());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
