package designpattern.creation.builder2;

/**
 * @author Cytang
 * @title: ColdDrink
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:20
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}
