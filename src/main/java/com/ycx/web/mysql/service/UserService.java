package com.ycx.web.mysql.service;

import com.ycx.web.mongo.entity.UserInfo;
import com.ycx.web.mysql.dao.UserDao;
import com.ycx.web.mysql.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ycx
 * @description 用户的服务类
 * @date 2020/5/6 11:54 下午
 **/
@Component
public class UserService implements UserDetailsService {

    @Resource
    private UserDao userDao;
    /**
     * 保存用户信息
     * @param userInfo userInfo
     * @return UserInfo
     */
    public User save(User userInfo) {
        if (null == userInfo) {
            return null;
        }
        return userDao.save(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
