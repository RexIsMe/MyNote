package com.example.demo.module.localhibernate.dao;

import com.example.demo.module.localhibernate.entity.SqlTest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rex
 * @title: SqlTestRepository
 * @projectName demoNote
 * @description: 继承JpaRepository，
 * @date 2020/5/810:06
 */
public interface SqlTestRepository extends JpaRepository<SqlTest, Integer> {

    SqlTest findByName(String name);

}
