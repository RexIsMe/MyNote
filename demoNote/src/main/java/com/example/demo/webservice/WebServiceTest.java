package com.example.demo.webservice;


import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;

public class WebServiceTest {

    public static void main(String[] args) {
        //服务地址
        String url = "http://localhost:8080/services/CommonService?wsdl";
        //方法名
        String method = "sayHello";
        try {
            DynamicClientFactory factory = DynamicClientFactory.newInstance();
            Client client = factory.createClient(url);
//            Object[] resultObject = client.invoke(method, new Object[]{"test", "queryOrder", "{\"tradeno\":\"1648100061003\",\"mchid\":\"10001\"}"});
            Object[] resultObject = client.invoke(method);
            String resultStr = resultObject[0].toString();  //接口调用结果
            System.out.println("服务调用结果：" + resultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
