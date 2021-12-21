package designpattern.creation.factory;

/**
 * "颜色"工厂类，用于根据需要返回指定示例
 *
 * @author Cytang
 * @title: ColorFactory
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1014:35
 */
public class ColorFactory {

    Color getInstance(String str){
        Color cf;
        if("red".equalsIgnoreCase(str)){
            cf = new Red();
        } else if("green".equalsIgnoreCase(str)){
            cf = new Green();
        } else {
            cf = new Yellow();
        }
        return cf;
    }

    void draw(){};

}
