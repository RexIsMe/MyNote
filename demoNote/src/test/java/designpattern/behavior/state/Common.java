package designpattern.behavior.state;

/**
 * 【状态模式】当一个对象的行为由状态决定时，就可以把一个个具体的状态和对应的行为封装成一个类，
 * 避免众多状态和行为在一个类中，难以应对多个变更，使不满足开闭原则
 *
 * 这个模式也和工厂方法模式、策略模式等类似；但是这个的侧重点在状态的切换，还有一种实现是状态的转换在具体的状态类中进行，而不是明确地指定
 *
 * @Author li zhiqang
 * @create 2021/12/9
 */
public class Common {

    public static void main(String[] args){

        Work work = new Work();
        work.setState(new AMState());
        work.doWork();
        work.setState(new PMState());
        work.doWork();
        work.setState(new NightState());
        work.doWork();

    }

}
