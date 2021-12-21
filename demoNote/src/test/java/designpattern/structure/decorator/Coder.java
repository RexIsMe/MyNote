package designpattern.structure.decorator;

/**
 * 程序员
 *
 * @Author li zhiqang
 * @create 2021/12/2
 */
public class Coder implements Component {
    @Override
    public void wear() {
        System.out.println("i wear ...");
    }

    private void code(){
        System.out.println("i can do it");
    }


    public static void main(String[] args){

        Coder coder = new Coder();
        Jeans jeans = new Jeans();
        Suits suits = new Suits();

        jeans.setComponent(coder);
        suits.setComponent(jeans);

        suits.wear();

        suits.setComponent(coder);
        jeans.setComponent(suits);
        jeans.wear();

    }

}
