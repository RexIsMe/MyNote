package designpattern.creation.singleton;

/**
 * 懒汉式3
 *      线程安全，且性能较直接在获取对象的方法上加synchronized性能高
 *
 * @author Cytang
 * @title: Singleton4
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1013:22
 */
public class Singleton4 {
    private Singleton4() {
    }

    //volatile防止执行singleton4 = new Singleton4();时的指令重排序，而返回一个未被初始化的对象
    private static volatile Singleton4 singleton4;

    public static Singleton4 getInstance(){
        //第一次检查：过滤掉绝大多数情况下获取对象
        if(singleton4 == null){
            synchronized (Singleton4.class){
                //第二次检查：避免在第一次创建该对象时的并发场景下导致多次创建
                if(singleton4 == null){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }

}
