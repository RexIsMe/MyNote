package designpattern.behavior.observer.entrust;

/**
 * @Author li zhiqang
 * @create 2021/12/3
 */
public class NotifierImpl extends NotifierAbstract {
    @Override
    public void registeListener(Object object, String methodName, Object... args) {
        System.out.println("有新的方法注册到委托类中了，实现类为：" + object.getClass().getName());
        this.getEventHandler().registEvent(object, methodName, args);
    }

    @Override
    public void notifyEvents() {
        System.out.println("唤起委托下的所有实现类!");
        try {
            this.getEventHandler().notifySomeone();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

