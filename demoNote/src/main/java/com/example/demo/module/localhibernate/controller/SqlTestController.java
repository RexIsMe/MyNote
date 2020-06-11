package com.example.demo.module.localhibernate.controller;

import com.example.demo.module.localhibernate.dao.SqlTestRepository;
import com.example.demo.module.localhibernate.entity.SqlTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rex
 * @title: SqlTestController
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/810:09
 */
@RestController
@RequestMapping("sqltest")
public class SqlTestController {

    @Autowired
    private SqlTestRepository sqlTestRepository;


    @GetMapping("/getAllSqlTest")
    @ResponseBody
    public List<SqlTest> findAll() {
        List<SqlTest> list;
        list = sqlTestRepository.findAll();
        return list;
    }

    @GetMapping("/getByUserName")
    @ResponseBody
    public SqlTest getByUserName(String name) {
        SqlTest user = sqlTestRepository.findByName(name);
        return user;
    }

}
