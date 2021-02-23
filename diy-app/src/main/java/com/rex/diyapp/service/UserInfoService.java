package com.rex.diyapp.service;

import com.rex.diyapp.entity.UserInfo;

import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/2/20
 */
public interface UserInfoService {
    // 写入数据
    void saveData (UserInfo userInfo) ;
    // ID 查询
    UserInfo selectById (Integer id) ;
    // 查询全部
    List<UserInfo> selectList () ;
}
