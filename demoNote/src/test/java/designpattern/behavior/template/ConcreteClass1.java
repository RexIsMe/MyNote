package designpattern.behavior.template;

/**
 * @Author li zhiqang
 * @create 2021/12/17
 */
public class ConcreteClass1 extends AbstractClass {
    @Override
    public void primitiveOperation1() {
        System.out.println("具体类1 方法1 实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类1 方法2 实现");
    }
}
