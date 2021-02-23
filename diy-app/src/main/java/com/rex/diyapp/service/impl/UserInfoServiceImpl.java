package com.rex.diyapp.service.impl;

import com.rex.diyapp.entity.UserInfo;
import com.rex.diyapp.mapper.UserInfoMapper;
import com.rex.diyapp.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/2/20
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper ;

    @Override
    public void saveData(UserInfo userInfo) {
        userInfoMapper.saveData(userInfo);
    }

    @Override
    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectById(id);
    }

    @Override
    public List<UserInfo> selectList() {
        return userInfoMapper.selectList();
    }
}
