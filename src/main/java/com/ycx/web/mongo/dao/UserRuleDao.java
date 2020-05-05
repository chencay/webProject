package com.ycx.web.mongo.dao;

import com.ycx.web.mongo.entity.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRuleDao extends MongoRepository<UserRole, String> {
}
