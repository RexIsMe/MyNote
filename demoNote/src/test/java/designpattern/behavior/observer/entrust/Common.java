package designpattern.behavior.observer.entrust;

import java.util.Date;

/**
 * “委托”+ 观察者模式
 *
 * @Author li zhiqang
 * @create 2021/12/3
 */
public class Common {

    public static void main(String[] args) {
        NotifierImpl notifier = new NotifierImpl();

        AListener a = new AListener();

        notifier.registeListener(a, "operation", new Date());

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        notifier.notifyEvents();
    }


}
