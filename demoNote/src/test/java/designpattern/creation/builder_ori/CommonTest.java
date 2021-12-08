package designpattern.creation.builder_ori;

/**
 * <p>Title: CommonTest</p>
 * <p>Description: 将一个复杂对象的创建的各个步骤封装到一个接口中，这个接口下可以有多种不同实现，再通过一个指挥者封装具体的对象的创建步骤组合起来</p>
 *  注意与模板模式比较，很类似，个人认为是侧重点不同；且建造者模式是包含模板模式的
 * <p>Company: Intellifusion</p>
 *
 * @author Lzq
 * @version V1.0
 * @date 2019/7/4 9:40
 */

public class CommonTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Director director=new Director();//指挥者角色
        //一部电影的产生
        MovieBuilder movieBuilder=new MovieBuilder();
        Product movie=director.bulidProduct(movieBuilder);
        System.out.println(movie.printString());
        // 一部小说的产生
        BookBuilder bookBuilder=new BookBuilder();
        Product book=director.bulidProduct(bookBuilder);
        System.out.println(book.printString());
    }

}
