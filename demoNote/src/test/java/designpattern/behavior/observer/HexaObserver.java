package designpattern.behavior.observer;

/**
 * @Author li zhiqang
 * @create 2020/12/9
 */
public class HexaObserver extends Observer{

    public HexaObserver(Subject1 subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
