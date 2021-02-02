package com.example.demo.module.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author li zhiqang
 * @create 2021/1/4
 */
public class NormalHandler implements InvocationHandler {

    //目标对象
    private Object target;

    public NormalHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        L.d("man say invoked at : " + System.currentTimeMillis());
        method.invoke(target, args); // 服务类自动实现。
        return null;
    }
}
