package interview.thread;

/**
 * 子线程抛出异常，主线程无法感知
 * 但是可以通过Thread的setUncaughtExceptionHandler方法获取到
 *
 * @Author li zhiqang
 * @create 2022/4/6
 */
public class ThreadExceptionTest {

    public static void main(String[] args) {
        try {
            ThreadThread threadThread = new ThreadThread();
            //通过Thread.UncaughtExceptionHandler还是可以获取继承了Thread类的异常信息
//            threadThread.setUncaughtExceptionHandler(
//                    new Thread.UncaughtExceptionHandler() {
//                @Override
//                public void uncaughtException(Thread t, Throwable e) {
//                    System.out.println(t.getName() + " " + e.getMessage());
//                }
//            });
            threadThread.start();
        } catch (Exception e){
            System.out.println("异常信息：" + e.getMessage());
        }

        System.out.println("主线程完成");
    }
}

class ThreadThread extends Thread {
    @Override
    public void run() {
//        System.out.println("ASDASDASD");
        int i = 1/0;
    }
}