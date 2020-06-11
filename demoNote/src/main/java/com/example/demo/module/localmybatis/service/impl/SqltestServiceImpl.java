package com.example.demo.module.localmybatis.service.impl;

import com.example.demo.module.localmybatis.entity.SqlTestBean;
import com.example.demo.module.localmybatis.mapper.SqlTestMapper;
import com.example.demo.module.localmybatis.service.SqlTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rex
 * @title: SqltestServiceImpl
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/811:01
 */
@Service
public class SqltestServiceImpl implements SqlTestService {

    @Autowired
    private SqlTestMapper sqlTestMapper;

    @Override
    public SqlTestBean getById(Integer id) {
        return sqlTestMapper.getById(id);
    }

    @Override
    public List<SqlTestBean> findAll(SqlTestBean sqlTestBean) {
        return sqlTestMapper.findAll(sqlTestBean);
    }
}
