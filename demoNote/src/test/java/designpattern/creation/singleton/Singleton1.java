package designpattern.creation.singleton;

/**
 * 饿汉式
 *
 * @author Cytang
 * @title: Singleton1
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1013:16
 */
public class Singleton1 {

    private Singleton1() {
    }

    private static final Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getInstance(){
        return singleton1;
    }

}
