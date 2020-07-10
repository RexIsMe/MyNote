package designpattern.creation.proto;

/**
 * 【原型模式】
 *
 * @author Cytang
 * @title: Shape
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:18
 */
public abstract class Shape implements Cloneable{

    abstract void draw();


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
