package designpattern.creation.singleton;

/**
 * 懒汉式2
 *      线程安全，但是性能低，因为99%获取对象时是不需要同步的
 * @author Cytang
 * @title: Singleton3
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1013:20
 */
public class Singleton3 {
    private Singleton3() {
    }

    private static volatile Singleton3 singleton3;

    public static synchronized Singleton3 getInstance(){
        if(singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }

}
