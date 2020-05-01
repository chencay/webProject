package com.ycx.web.mysql.entity;

import javax.persistence.Entity;

/**
 * @author ycx
 * @description 用户角色
 * @date 2020/5/1 10:25 上午
 **/
@Entity(name = "role")
public class Role extends IdEntity{
    /**角色名称**/
    private String roleName;
    /**中文角色名称**/
    private String roleChName;

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
