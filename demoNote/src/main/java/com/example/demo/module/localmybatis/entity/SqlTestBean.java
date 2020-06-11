package com.example.demo.module.localmybatis.entity;

import lombok.Data;

/**
 * @author Rex
 * @title: SqlTestBean
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/810:44
 */
public class SqlTestBean {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SqlTestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
