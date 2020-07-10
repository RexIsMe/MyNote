package designpattern.creation.abstractfactory;

/**
 * @author Cytang
 * @title: AbstractFactoryDemo
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:09
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        FactoryProducer fp = new FactoryProducer();

        AbstractFactory colorFactory = fp.getFactory("color");
        colorFactory.getColor("Red").draw();
        colorFactory.getColor("green").draw();
        colorFactory.getColor("yellow").draw();

        AbstractFactory shapeFactory = fp.getFactory("shape");
        shapeFactory.getShape("Circle").panitting();
        shapeFactory.getShape("Triangle").panitting();
        shapeFactory.getShape("Square").panitting();

    }

}
