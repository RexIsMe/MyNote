package designpattern.creation.abstractfactory;

/**
 * @author Cytang
 * @title: FactoryProducer
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:07
 */
public class FactoryProducer {

    AbstractFactory getFactory(String str){
        AbstractFactory af;
        if("color".equalsIgnoreCase(str)){
            af = new ColorFactory();
        } else {
            af = new ShapeFactory();
        }
        return af;
    }

}
