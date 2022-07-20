package com.example.demo.webservice;

/**
 * @author copa
 * @createDate 2022-01-11 17:16
 * @function User接口
 */
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UserService {

    @WebMethod
    User publishUserInfo();
}