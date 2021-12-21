package designpattern.behavior.visitor;

/**
 * @Author li zhiqang
 * @create 2021/12/15
 */
public interface Element {

    void accept(Visitor visitor);

}
