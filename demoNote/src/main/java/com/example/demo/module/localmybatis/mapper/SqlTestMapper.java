package com.example.demo.module.localmybatis.mapper;

import com.example.demo.module.localmybatis.entity.SqlTestBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Rex
 * @title: SqlTestMapper
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/810:46
 */
@Mapper
public interface SqlTestMapper {

    /**
     * 通过id查询信息
     * @param id id
     * @return teacher信息
     */
    SqlTestBean getById(@Param("id") Integer id);

    /**
     * specially:当sql中用到了<where  / <if  标签 时，参数上要带上@Param注解
     * @param sqlTestBean
     * @return
     */
    List<SqlTestBean> findAll(@Param("sqlTestBean") SqlTestBean sqlTestBean);

}
