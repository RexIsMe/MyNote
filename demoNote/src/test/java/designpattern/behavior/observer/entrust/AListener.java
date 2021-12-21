package designpattern.behavior.observer.entrust;

import java.util.Date;

/**
 * 测试用监听器，事件触发后，被委托的具体的处理方法所在的类
 *
 * @Author li zhiqang
 * @create 2021/12/3
 */
public class AListener {
    public AListener(){
        System.out.println("创建 A 类监听者");
    }

    public void operation(Date date){
        System.out.println("A 类事件具体操作, 发生时间：" + date);
    }
}

