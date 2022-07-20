package com.example.demo.webservice;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

/**
 * 接口实现
 *
 * @author leftso
 *
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://web.test.wang/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.example.demo.webservice.CommonService"// 接口地址
)
@Component
public class CommonServiceImp implements CommonService {

    @Override
    public String sayHello(String name) {

        return "Hello ," + name;
    }

}
