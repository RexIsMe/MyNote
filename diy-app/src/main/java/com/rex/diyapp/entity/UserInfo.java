package com.rex.diyapp.entity;

import lombok.Data;

/**
 * clickhouse建表语句
 * CREATE TABLE test.cs_user_info( `id` Int32, `user_name` String, `pass_word` String, `phone` String, `email` String, `create_day` String ) ENGINE = MergeTree ORDER BY id SETTINGS index_granularity = 8192
 *
 * @Author li zhiqang
 * @create 2021/2/20
 */
@Data
public class UserInfo {

    public Integer id;
    public String userName;
    public String passWord;
    public String phone;
    public String email;
    public String createDay;

}
