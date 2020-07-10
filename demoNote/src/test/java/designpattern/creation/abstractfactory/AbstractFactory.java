package designpattern.creation.abstractfactory;

/**
 * @author Cytang
 * @title: AbstractFactory
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:02
 */
public interface AbstractFactory {

    Color getColor(String str);
    Shape getShape(String str);

}
