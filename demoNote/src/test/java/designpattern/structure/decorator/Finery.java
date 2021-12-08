package designpattern.structure.decorator;

/**
 * @Author li zhiqang
 * @create 2021/12/2
 */
public abstract class Finery implements Component{

    private Component man;

    public void setComponent(Component man){
        this.man = man;
    }

    @Override
    public void wear() {
        man.wear();
    }
}
