package designpattern.behavior.observer;

/**
 * @Author li zhiqang
 * @create 2020/12/9
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
