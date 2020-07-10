package designpattern.behavior.dutychain;

/**
 * @author Cytang
 * @title: FileLogger
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1010:40
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }

}
