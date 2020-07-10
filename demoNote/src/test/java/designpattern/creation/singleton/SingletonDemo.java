package designpattern.creation.singleton;

import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * 【单例模式】
 * 保证系统中这个类只有一个实例
 *
 * @author Cytang
 * @title: SingletonDemo
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1013:14
 */
public class SingletonDemo {
    public static Set objSet = new HashSet<String>();

    public static void main(String[] args) throws InterruptedException {

        /** 验证单线程下的单例创建 */
//        Singleton1 singleton1 = Singleton1.getInstance();
//        Singleton2 singleton2 = Singleton2.getInstance();
//        Singleton3 singleton3 = Singleton3.getInstance();
//        Singleton4 singleton4 = Singleton4.getInstance();
//        Singleton5 singleton5 = Singleton5.getInstance();
//        Singleton6 singleton6 = Singleton6.SINGLETON_6;
//
//        Singleton1 singleton11 = Singleton1.getInstance();
//        Singleton2 singleton21 = Singleton2.getInstance();
//        Singleton3 singleton31 = Singleton3.getInstance();
//        Singleton4 singleton41 = Singleton4.getInstance();
//        Singleton5 singleton51 = Singleton5.getInstance();
//        Singleton6 singleton61 = Singleton6.SINGLETON_6;
//
//        System.out.println(singleton1.equals(singleton11));
//        System.out.println(singleton2.equals(singleton21));
//        System.out.println(singleton3.equals(singleton31));
//        System.out.println(singleton4.equals(singleton41));
//        System.out.println(singleton5.equals(singleton51));
//        System.out.println(singleton6.equals(singleton61));


        /** 制造并发场景，体现Singleton2非线程安全*/
        for (int i = 0; i < 20000; i++) {
            new Thread(new Runnable(){
                @SneakyThrows
                @Override
                public void run() {
                    //先睡100ms,提高创建对象时的并发
                    Thread.sleep(1000);

                    Singleton2 instance = Singleton2.getInstance();
                    objSet.add(instance.toString());
//                    System.out.println(Thread.currentThread().getName() + "执行" + Singleton2.getInstance());
                }
            }).start();
        }

        Thread.sleep(10000);

        Iterator<String> iterator = objSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
