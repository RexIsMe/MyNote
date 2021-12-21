package designpattern.behavior.visitor;

/**
 * @Author li zhiqang
 * @create 2021/12/15
 */
public class ConcreteVisitor1 extends Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getName() + "被" + this.getClass().getName() + "访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getName() + "被" + this.getClass().getName() + "访问");
    }
}
