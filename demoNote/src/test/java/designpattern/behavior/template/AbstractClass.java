package designpattern.behavior.template;

/**
 * @Author li zhiqang
 * @create 2021/12/17
 */
public abstract class AbstractClass {

    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();

    public void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
        System.out.println("模板方法执行完成");
    }

}
