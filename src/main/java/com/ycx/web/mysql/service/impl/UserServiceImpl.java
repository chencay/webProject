package com.ycx.web.mysql.service.impl;

import com.ycx.web.mysql.dao.UserDao;
import com.ycx.web.mysql.entity.User;
import com.ycx.web.mysql.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ycx
 * @description 描述
 * @date 2020/5/6 11:56 下午
 **/
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User save(User userInfo) {
        if (null == userInfo) {
            return null;
        }
        return userDao.save(userInfo);
    }
}
