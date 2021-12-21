package designpattern.behavior.order;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务员类
 *
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class Waiter {

    private List<Command> commandList = new ArrayList<>();

    public void reciveCommand(Command command){
        commandList.add(command);
    }

    //撤销...

    //修改...


    public void execute(){
        for (Command command : commandList) {
            command.doIt();
        }
    }
}
