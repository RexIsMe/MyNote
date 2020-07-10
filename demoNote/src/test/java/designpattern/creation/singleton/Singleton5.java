package designpattern.creation.singleton;

import org.apache.commons.math3.analysis.function.Sin;

/**
 * 内部类方式
 *      利用了静态属性随类加载只执行一次，和内部类在显示调用时才加载达到延迟加载的目的
 *
 * @author Cytang
 * @title: Singleton5
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1013:28
 */
public class Singleton5 {
    private Singleton5() {
    }

    public static Singleton5 getInstance(){
        return InerSingleton5.singleton5;
    }

    public static class InerSingleton5{
        private static final Singleton5 singleton5 = new Singleton5();
    }

}
