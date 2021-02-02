package com.example.demo.module.aop;

import freemarker.template.SimpleDate;

import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author li zhiqang
 * @create 2021/1/4
 */
public class Common {

    public static void main(String[] args) throws ParseException {

//        Man man = new Man();
//        NormalHandler normalHandler = new NormalHandler(man);
//        IPerson iPerson = (IPerson)
//                // 通过此方法获得动态代理对象
//                Proxy.newProxyInstance(IPerson.class.getClassLoader(),
////                        new Class[] {IPerson.class, IAnimal.class}, annotationHandler);
//                        new Class[] {IPerson.class}, normalHandler);
//        iPerson.say();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("2021-01-03");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        System.out.println(calendar.getTimeInMillis());


    }

}
