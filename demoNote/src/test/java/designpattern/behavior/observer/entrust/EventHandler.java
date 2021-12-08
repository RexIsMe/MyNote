package designpattern.behavior.observer.entrust;

import java.util.ArrayList;
import java.util.List;

/**
 * 委托类
 *
 * @Author li zhiqang
 * @create 2021/12/3
 */
public class EventHandler {
    private List<Event> events;

    public EventHandler() {
        events = new ArrayList<>();
    }

    public void registEvent(Object object, String methodName, Object... args){
        System.out.println("将类" + object.getClass().getName() + "委托给EventHandler");
        this.events.add(new Event(object, methodName, args));
    }

    public void notifySomeone() throws Exception{
        for(Event e : events){
            e.invoke();
        }
    }
}

