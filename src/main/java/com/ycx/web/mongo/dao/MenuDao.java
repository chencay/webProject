package com.ycx.web.mongo.dao;

import com.ycx.web.mongo.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuDao extends MongoRepository<Menu, String> {
}
