package designpattern.behavior.observer;

/**
 * 被通知者（观察者通知对象抽象类）
 *
 * @Author li zhiqang
 * @create 2020/12/9
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
