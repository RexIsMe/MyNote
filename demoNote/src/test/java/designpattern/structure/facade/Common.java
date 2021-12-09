package designpattern.structure.facade;

/**
 * 【外观模式】将某种类型的一个个具体的类组合到一个类中，通过这个类（门面）来统一对外提供服务
 *
 * @Author li zhiqang
 * @create 2021/12/8
 */
public class Common {

    public static void main(String[] args){
        Facade facade = new Facade();
        facade.work1();
        facade.work2();
        facade.work3();
    }

}
