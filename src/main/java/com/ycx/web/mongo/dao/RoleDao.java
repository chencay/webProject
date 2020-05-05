package com.ycx.web.mongo.dao;

import com.ycx.web.mongo.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleDao extends MongoRepository<Role, String> {
}
