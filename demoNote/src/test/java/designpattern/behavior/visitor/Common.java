package designpattern.behavior.visitor;

/**
 * 【访问者模式】双分流
 *  1、在客户程序中将具体状态作为参数传递给“男人”类完成一次分配
 *  2、“男人”类调用作为参数的“具体状态”中的方法“男人反应”，同时将自己（this）作为参数传递进去
 *
 *  此时如果新增具体的状态类（访问者），只需要增加对应类而不用修改已有代码
 *
 * @Author li zhiqang
 * @create 2021/12/15
 */
public class Common {

    public static void main(String[] args){
        DataStructrue dataStructrue = new DataStructrue();
        ConcreteElementA concreteElementA = new ConcreteElementA();
        ConcreteElementB concreteElementB = new ConcreteElementB();
        dataStructrue.addEle(concreteElementA);
        dataStructrue.addEle(concreteElementB);

        dataStructrue.accept(new ConcreteVisitor1());
        dataStructrue.accept(new ConcreteVisitor2());
    }

}
