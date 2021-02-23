package com.rex.diyapp.mapper;

import com.rex.diyapp.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/2/19
 */
@Mapper
public interface UserInfoMapper {
    // 写入数据
    void saveData (UserInfo userInfo) ;
    // ID 查询
    UserInfo selectById (@Param("id") Integer id) ;
    // 查询全部
    List<UserInfo> selectList () ;
}
