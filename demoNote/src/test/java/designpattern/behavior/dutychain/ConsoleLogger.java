package designpattern.behavior.dutychain;

/**
 * @author Cytang
 * @title: ConsoleLogger
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1010:39
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
