package designpattern.behavior.visitor;

/**
 * @Author li zhiqang
 * @create 2021/12/15
 */
public class ConcreteElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }
}
