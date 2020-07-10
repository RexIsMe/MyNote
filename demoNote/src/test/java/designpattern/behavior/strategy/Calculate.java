package designpattern.behavior.strategy;

/**
 * 【策略模式】
 * 一个对象有多种行为，根据具体对象选择执行对应行为
 *
 * 计算的抽象类
 * @author Rex
 */
public interface Calculate {

    String cal(int a, int b);
    String cal(double a, double b);

}
