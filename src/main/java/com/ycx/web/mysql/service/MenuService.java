package com.ycx.web.mysql.service;

import com.ycx.web.mysql.entity.Menu;

import java.util.List;

/**
 * @author ycx
 * @description menu的服务类
 * @date 2020/5/8 9:25 下午
 **/
public interface MenuService {

    /**
     * 获取所有的menu
     * @return List<Menu>
     */
    List<Menu> getAllMenus();
}
