package interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author li zhiqang
 * @create 2022/4/6
 */
public class ThirdThreadTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception
    {
        int i = 0;
        for(;i<2;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            int a = 1/0;
        }
        return i;
    }

    public static void main(String[] args)
    {
        ThirdThreadTest ctt = new ThirdThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(int i = 0;i < 20;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==10)
            {
                new Thread(ft,"有返回值的线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());
        } catch (Exception e)
        {
            System.out.println("异常信息：");
            e.printStackTrace();
        }




    }



}
