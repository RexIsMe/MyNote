package designpattern.behavior.observer;

/**
 * 观察者模式
 * 目的：使根据事件立即做出反应
 *
 * 关键设计：被观察者有一个观察列表，做出动作后，调用观察列表的每个方法
 *
 * @Author li zhiqang
 * @create 2020/12/9
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
