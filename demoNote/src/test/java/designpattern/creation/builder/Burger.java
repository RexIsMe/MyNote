package designpattern.creation.builder;

/**
 * @author Cytang
 * @title: Burger
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:20
 */
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}
