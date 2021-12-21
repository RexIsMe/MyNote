package designpattern.behavior.visitor;

/**
 * 访问者模式的一个前提就是观察者类一般情况下稳定不变（这里只有两种）
 *
 * @Author li zhiqang
 * @create 2021/12/15
 */
public abstract class Visitor {

    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);

    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);

}
