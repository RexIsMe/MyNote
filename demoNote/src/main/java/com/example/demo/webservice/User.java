package com.example.demo.webservice;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author copa
 * @createDate 2022-01-11 17:15
 * @function User实体类
 */
@Data
@Accessors(chain = true)
public class User {

    private String id;

    private String name;
}
