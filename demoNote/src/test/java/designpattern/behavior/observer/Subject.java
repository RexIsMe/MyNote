package designpattern.behavior.observer;

import lombok.Data;

/**
 * 观察者接口
 * 1、面对接口或抽象编程
 * 2、当有不同类型的观察者对象时，也无需改变已有
 *
 * @Author li zhiqang
 * @create 2021/12/6
 */
@Data
abstract class Subject {

    abstract void attach(Observer observer);
    int state = 0;
}
