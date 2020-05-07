package com.ycx.web.mongo.dao;

import com.ycx.web.mongo.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoDao extends MongoRepository<UserInfo, String> {

    /**
     * 根据用户名查找用户信息
     * @param username username
     * @return UserInfo
     */
    UserInfo findByUsername(String username);

}
