package com.ycx.web.mysql.dao;

import com.ycx.web.mysql.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuDao extends JpaRepository<Menu, Long> {
}
