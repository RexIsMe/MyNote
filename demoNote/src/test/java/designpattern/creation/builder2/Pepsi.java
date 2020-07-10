package designpattern.creation.builder2;

/**
 * @author Cytang
 * @title: Pepsi
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:23
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }

}
