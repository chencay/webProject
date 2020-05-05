package com.ycx.web.mongo.service;

import com.ycx.web.mongo.entity.UserInfo;

/**
 * @author ycx
 * @description 用户信息的服务类
 * @date 2020/5/5 9:08 下午
 **/
public interface UserInfoService {

    /**
     * 保存用户信息
     * @param userInfo userInfo
     * @return UserInfo
     */
    UserInfo save(UserInfo userInfo);
}
