package com.ycx.web.mysql.dao;

import com.ycx.web.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
