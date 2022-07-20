package com.example.demo.webservice;

import javax.xml.ws.Endpoint;

/**
 * @author copa
 * @createDate 2022-01-11 17:19
 * @function 服务端测试类
 */
public class MyServerTest {

    public static void main(String[] args) {
        String address = "http://localhost:2333/user_server.asmx";
        Endpoint.publish(address, new UserServiceImpl());
        System.out.println("发布成功！");
    }
}
