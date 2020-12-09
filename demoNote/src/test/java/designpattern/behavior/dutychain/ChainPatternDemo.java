package designpattern.behavior.dutychain;

/**
 * 责任链模式
 * 目的是拆分不同的handler处理,使代码不至于过于耦合；同时相较于策略模式，责任链模式中的各个handler可以进行部分处理
 *
 * 关键实现：每个handler有下一个handler的对象
 *
 * @author Cytang
 * @title: ChainPatternDemo
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1010:41
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }

}
