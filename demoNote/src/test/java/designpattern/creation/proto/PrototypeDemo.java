package designpattern.creation.proto;

/**
 * @author Cytang
 * @title: PrototypeDemo
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:28
 */
public class PrototypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        ShapePrototype shapePrototype = new ShapePrototype();
        Shape circle = shapePrototype.getInstance("Circle");
        System.out.println(circle instanceof Circle);
        System.out.println(circle.equals(ShapePrototype.shapeMap.get("Circle")));

        Shape square = shapePrototype.getInstance("Square");
        System.out.println(square instanceof Square);
        System.out.println(square.equals(ShapePrototype.shapeMap.get("Square")));

        Shape triangle = shapePrototype.getInstance("Triangle");
        System.out.println(triangle instanceof Triangle);
        System.out.println(triangle.equals(ShapePrototype.shapeMap.get("Triangle")));

    }

}
