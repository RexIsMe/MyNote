package com.example.demo.module.localhibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rex
 * @title: SqlTest
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/810:02
 */

@Entity
@Table(name = "sqltest")
@Data
public class SqlTest implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

}
