package interview.thread;

/**
 * @Author li zhiqang
 * @create 2022/4/6
 */
public class FirstThreadTest extends Thread{

    int i = 0;
    //重写run方法，run方法的方法体就是现场执行体
    public void run()
    {
        for(;i<2;i++){
            System.out.println(getName()+"  "+i);
        }
    }
    public static void main(String[] args)
    {
        for(int i = 0;i< 20;i++)
        {
            System.out.println(Thread.currentThread().getName()+"  : "+i);
            if(i==10)
            {
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }
    }

}
