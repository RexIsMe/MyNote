package com.example.demo.module.localmybatis.controller;

import com.example.demo.module.localmybatis.entity.SqlTestBean;
import com.example.demo.module.localmybatis.service.SqlTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rex
 * @title: SqlTestController
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/810:55
 */
@RestController
@RequestMapping("sqltest-mybatis")
public class SqlTestControllerMybatis {

    /**
     * 注入服务
     */
    @Autowired
    private SqlTestService sqlTestService;


    @GetMapping(value = "/getById")
    @ResponseBody
    public SqlTestBean getTeacherMessage(Integer id){
        return sqlTestService.getById(id);
    }

//    @PostMapping(value = "/findAll")
//    @ResponseBody
//    public List<SqlTestBean> findAll(@RequestBody JSONObject jsonObject){
//        SqlTestBean sqlTestBean = JSON.parseObject(jsonObject.toJSONString(), SqlTestBean.class);
//        return sqlTestService.findAll(sqlTestBean);
//    }

    @PostMapping(value = "/findAll")
    @ResponseBody
    public List<SqlTestBean> findAll(@RequestBody SqlTestBean sqlTestBean){
        return sqlTestService.findAll(sqlTestBean);
    }

}
