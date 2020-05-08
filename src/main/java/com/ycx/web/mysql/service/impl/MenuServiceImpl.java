package com.ycx.web.mysql.service.impl;

import com.ycx.web.mysql.dao.MenuDao;
import com.ycx.web.mysql.entity.Menu;
import com.ycx.web.mysql.service.MenuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ycx
 * @description menuService的实现类
 * @date 2020/5/8 9:30 下午
 **/
@Component
public class MenuServiceImpl implements MenuService {
    /** MenuDao **/
    @Resource
    MenuDao menuDao;

    @Override
    public List<Menu> getAllMenus() {
        return menuDao.findAll();
    }
}
