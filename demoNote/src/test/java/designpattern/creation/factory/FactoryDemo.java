package designpattern.creation.factory;

/**
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
