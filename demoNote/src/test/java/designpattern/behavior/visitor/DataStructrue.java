package designpattern.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/12/15
 */
public class DataStructrue {
    private List<Element> elements = new ArrayList<>();

    public void addEle(Element element){
        elements.add(element);
    }

    public void removeEle(Element element){
        elements.remove(element);
    }

    public void accept(Visitor visitor){
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

}
