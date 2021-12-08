package designpattern.behavior.observer.entrust;

/**
 * 关联委托和委托下具体实现方法的抽象类
 *
 * @Author li zhiqang
 * @create 2021/12/3
 */
public abstract class NotifierAbstract {
    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    //将具体实现注册到委托类中
    public abstract void registeListener(Object object, String methodName, Object... args);

    //唤起所有委托类中维护的具体实现
    public abstract void notifyEvents();
}

