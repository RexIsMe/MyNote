package com.example.demo.webservice;

import javax.jws.WebService;

/**
 * @author copa
 * @createDate 2022-01-11 17:17
 * @function User接口实现类
 */
@WebService
public class UserServiceImpl implements UserService{

    @Override
    public User publishUserInfo() {
        System.out.println("开始进入该service啦~");
        return new User()
                .setId("1")
                .setName("copa");
    }
}
