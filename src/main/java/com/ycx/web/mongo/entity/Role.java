package com.ycx.web.mongo.entity;

import org.springframework.data.annotation.Id;


/**
 * @author ycx
 * @description 用户角色
 * @date 2020/5/1 10:25 上午
 **/
public class Role {
    /** id **/
    @Id
    private String id;
    /**角色名称**/
    private String roleName;
    /**中文角色名称**/
    private String roleChName;

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
     * getRoleName
     * @return String
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * setRoleName
     * @param roleName roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * getRoleChName
     * @return String
     */
    public String getRoleChName() {
        return roleChName;
    }

    /**
     * setRoleChName
     * @param roleChName roleChName
     */
    public void setRoleChName(String roleChName) {
        this.roleChName = roleChName;
    }
}
