package com.ycx.web.mongo.dao;

import com.ycx.web.mongo.entity.MenuRole;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRoleDao extends MongoRepository<MenuRole, String> {
}
