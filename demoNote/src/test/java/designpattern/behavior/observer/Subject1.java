package designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject1 extends Subject {

    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 这里不够灵活的点：
     * 1、被通知者方法名固定
     */
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
