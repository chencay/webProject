package com.ycx.web.mysql.entity;

import javax.persistence.Entity;

/**
 * @author ycx
 * @description 简单的用户信息
 * @date 2020/4/25 8:59 下午
 **/
@Entity(name = "user")
public class User extends ExpandEntity {

    /**用户名**/
    private String username;
    /**密码**/
    private String password;
    /**状态**/
    private int status;

    /**
     * getUsername
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * setUsername
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getPassword
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
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
}
