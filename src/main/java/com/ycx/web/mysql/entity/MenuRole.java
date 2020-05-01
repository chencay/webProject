package com.ycx.web.mysql.entity;

/**
 * @author ycx
 * @description 资源表与角色表的关联表
 * @date 2020/5/1 5:11 下午
 **/
public class MenuRole extends IdEntity{
    /** menu id**/
    private Long menuId;
    /** roleId**/
    private Long roleId;

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
