package designpattern.behavior.state;

/**
 * @Author li zhiqang
 * @create 2021/12/9
 */
public class AMState extends State {

    @Override
    void work() {
        System.out.println("上午元气满满，快乐工作");
    }
}
