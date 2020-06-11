package com.example.demo.module.localmybatis.service;

import com.example.demo.module.localmybatis.entity.SqlTestBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rex
 * @title: SqlTestService
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/810:58
 */
public interface SqlTestService {

    SqlTestBean getById(Integer id);

    List<SqlTestBean> findAll(SqlTestBean sqlTestBean);
}
