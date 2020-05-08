package com.ycx.web.mongo.service.impl;

import com.ycx.web.mongo.dao.UserInfoDao;
import com.ycx.web.mongo.entity.UserInfo;
import com.ycx.web.mongo.service.UserInfoService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ycx
 * @description UserInfoService的实现类
 * @date 2020/5/5 9:10 下午
 **/
@Component
public class UserInfoServiceImpl implements UserInfoService {

    /** UserInfoDao **/
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo save(UserInfo userInfo) {
        if (null == userInfo) {
            return null;
        }
        return userInfoDao.save(userInfo);
    }
}
