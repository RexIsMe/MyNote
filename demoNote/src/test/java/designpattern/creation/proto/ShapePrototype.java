package designpattern.creation.proto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cytang
 * @title: ShapePrototype
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:21
 */
public class ShapePrototype {

    public static Map<String, Shape> shapeMap = new HashMap(4);

    static {
        shapeMap.put("Circle", new Circle());
        shapeMap.put("Square", new Square());
        shapeMap.put("Triangle", new Triangle());
    }

    Shape getInstance(String str) throws CloneNotSupportedException {
        Shape shape = shapeMap.get(str);
        if("Circle".equalsIgnoreCase(str)){
            shape = (Circle)shape.clone();
        } else if("Square".equalsIgnoreCase(str)){
            shape = (Square)shape.clone();
        } else {
            shape = (Triangle)shape.clone();
        }
        return shape;
    }

}
