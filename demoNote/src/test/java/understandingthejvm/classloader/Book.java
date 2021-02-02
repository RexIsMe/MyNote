package understandingthejvm.classloader;

/**
 * @Author li zhiqang
 * @create 2021/2/2
 */
public class Book {
    public static void main(String[] args)
    {
        staticFunction();
    }



    static
    {
        System.out.println("书的静态代码块");
    }

    static Book book = new Book();

    {
        System.out.println("书的普通代码块");
    }

    Book()
    {
        System.out.println("书的构造方法");
        System.out.println("price=" + price +",amount=" + amount + ",test=" + test);
    }

    public static void staticFunction(){
        System.out.println("书的静态方法");
    }

    int price = 110;
    static int amount = 112;
    static final int test = 1024;
}
