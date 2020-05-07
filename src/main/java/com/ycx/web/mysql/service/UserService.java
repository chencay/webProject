package com.ycx.web.mysql.service;

import com.ycx.web.mongo.entity.UserInfo;
import com.ycx.web.mysql.entity.User;

/**
 * @author ycx
 * @description 用户的服务类
 * @date 2020/5/6 11:54 下午
 **/
public interface UserService {

    /**
     * 保存用户信息
     * @param userInfo userInfo
     * @return UserInfo
     */
    User save(User userInfo);
}
