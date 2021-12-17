package designpattern.behavior.template;

/**
 * 【模板方法模式】
 *  和建造者模式多比较、体会
 *
 * @Author li zhiqang
 * @create 2021/12/17
 */
public class Common {

    public static void main(String[] args){
        AbstractClass abstractClass;

        abstractClass = new ConcreteClass1();
        abstractClass.templateMethod();

        abstractClass = new ConcreteClass2();
        abstractClass.templateMethod();


    }

}
