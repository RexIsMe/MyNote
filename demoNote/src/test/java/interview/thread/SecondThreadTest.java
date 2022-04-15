package interview.thread;

/**
 * @Author li zhiqang
 * @create 2022/4/6
 */
public class SecondThreadTest implements Runnable{

    private int i;
    public void run()
    {
        for(i = 0;i <2;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
    public static void main(String[] args)
    {
        for(int i = 0;i < 20;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==10)
            {
                SecondThreadTest rtt = new SecondThreadTest();
                new Thread(rtt,"新线程1").start();
                new Thread(rtt,"新线程2").start();
            }
        }
    }

}
