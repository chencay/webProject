package com.ycx.web.mongo.entity;

import org.springframework.data.annotation.Id;


/**
 * @author ycx
 * @description 资源实体与角色实体关联的实体类
 * @date 2020/5/1 5:11 下午
 **/
public class MenuRole {

    /** id **/
    @Id
    private String id;
    /** menu id**/
    private Long menuId;
    /** roleId **/
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
     * getMenuId
     * @return Long
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * setMenuId
     * @param menuId menuId
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
