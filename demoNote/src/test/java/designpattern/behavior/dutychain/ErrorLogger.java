package designpattern.behavior.dutychain;

/**
 * @author Cytang
 * @title: ErrorLogger
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1010:40
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
