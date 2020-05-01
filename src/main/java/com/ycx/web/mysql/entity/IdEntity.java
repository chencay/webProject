package com.ycx.web.mysql.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author ycx
 * @description 统一定义id的基类
 * @date 2020/4/25 9:19 下午
 **/
//JPA基类的标示
@MappedSuperclass
public abstract class IdEntity {
    /**自增id**/
    protected Long id;

    /**
     * getId
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * setId
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
