package designpattern.creation.singleton;

/**
 * 懒汉式1
 *      线程不安全
 *
 * @author Cytang
 * @title: Singleton2
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1013:18
 */
public class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 singleton2;

    public static Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}
