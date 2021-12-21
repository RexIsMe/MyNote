package designpattern.behavior.state;

/**
 * @Author li zhiqang
 * @create 2021/12/9
 */
public class NightState extends State {

    @Override
    void work() {
        System.out.println("晚上丧气满满，无心工作");
    }
}
