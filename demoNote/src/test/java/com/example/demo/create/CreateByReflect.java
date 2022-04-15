package com.example.demo.create;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author li zhiqang
 * @create 2021/12/14
 */
public class CreateByReflect {
    public static void main(String[] args) throws Exception {
        Object object;
        Class cl = Class.forName("com.example.demo.create.TestMe");
        //方式一，这里调用的默认无参构造器
        object = cl.newInstance();
        System.out.println(object.hashCode());

        //方式二，这里调用的指定构造器
        Constructor constructor = cl.getDeclaredConstructor(new Class[]{String.class});
        object = constructor.newInstance(new Object[]{"Hello"});
        System.out.println(object.hashCode());
    }
}

class TestMe {
    private String str;

    public TestMe() {
    }

    public TestMe(String str) {
        this.str = str;
        System.out.println("In Constructor str = " + str);
    }

    public void print(String name) {
        System.out.println("In print str = " + str + " and name = " + name);
    }
}
