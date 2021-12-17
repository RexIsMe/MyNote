package designpattern.behavior.state;

import lombok.Data;

/**
 * @Author li zhiqang
 * @create 2021/12/9
 */
@Data
public class Work {

    private State state;

    public Work() {
    }

    public Work(State state) {
        this.state = state;
    }

    public void doWork(){
        state.work();
    }

}
