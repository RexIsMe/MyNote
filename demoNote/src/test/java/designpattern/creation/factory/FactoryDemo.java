package designpattern.creation.factory;

/**
 *
 * 工厂模式
 * 包含三种设计模式：
 * 简单工厂模式：为某接口的初始化复杂的实现类提供根据名称获取对象的方法
 * 工厂方式模式：每一个对象初始化复杂的类配置一个工厂方法，将对象的初始化工作搬到工厂方法中，提高该类代码的可读性
 * 抽象工厂模式：为对工厂类进行分类，减少工厂类的数量
 *
 * @author Cytang
 * @title: FactoryDemo
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1014:39
 */
public class FactoryDemo {

    public static void main(String[] args) {
        ColorFactory cf = new ColorFactory();

        cf.getInstance("red").draw();
        cf.getInstance("green").draw();
        cf.getInstance("yellow").draw();


    }

}
