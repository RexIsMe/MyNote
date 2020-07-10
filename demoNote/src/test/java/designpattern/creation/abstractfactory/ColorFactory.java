package designpattern.creation.abstractfactory;

/**
 * @author Cytang
 * @title: ColorFactory
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1014:57
 */
public class ColorFactory implements AbstractFactory {

    @Override
    public Color getColor(String str) {
        Color color;
        if("red".equalsIgnoreCase(str)){
            color = new Red();
        } else if("green".equalsIgnoreCase(str)){
            color = new Green();
        } else {
            color = new Yellow();
        }
        return color;
    }

    @Override
    public Shape getShape(String str) {
        return null;
    }


}
