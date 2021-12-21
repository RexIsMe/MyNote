package designpattern.behavior.moment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/12/9
 */
public class MomentManager {

    private List<Moment> moments;

    public MomentManager() {
        moments = new ArrayList<Moment>();
    }

    public void add(Moment moment){
        moments.add(moment);
    }

    public Moment getMoment(){
        return moments.get(0);
    }
    public Moment getMoment(int index){
        return moments.get(index);
    }

}
