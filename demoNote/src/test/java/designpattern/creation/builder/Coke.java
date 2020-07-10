package designpattern.creation.builder;

/**
 * @author Cytang
 * @title: Coke
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:22
 */
public class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
