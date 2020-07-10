package designpattern.creation.abstractfactory;

/**
 * @author Cytang
 * @title: ShapeFactory
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1014:59
 */
public class ShapeFactory implements AbstractFactory{

    @Override
    public Color getColor(String str) {
        return null;
    }

    @Override
    public Shape getShape(String str) {
        Shape shape;
        if("Circle".equalsIgnoreCase(str)){
            shape = new Circle();
        } else if("Triangle".equalsIgnoreCase(str)){
            shape = new Triangle();
        } else {
            shape = new Square();
        }
        return shape;
    }
}
