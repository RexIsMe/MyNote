package com.example.demo.lock;

/**
 * @Author li zhiqang
 * @create 2022/5/25
 */
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现一个可重入的自旋锁
 *
 * 当锁范围内的代码逻辑执行消耗时间 小于 cpu上下文切换的时间时可以使用自旋锁提升性能
 */
public class ReentrantSpinLock{

    private AtomicReference owner = new AtomicReference<>();

    //重入次数
    private int count = 0;

    public static void main(String[] args){
        ReentrantSpinLock spinLock = new ReentrantSpinLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了了自旋锁");
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }

    public void lock(){
        Thread t = Thread.currentThread();
        if (t == owner.get()) {
            ++count;
            return;
        }
        //自旋获取锁
        // 与互斥锁相比，自旋锁不会释放cpu资源，也避免了上下文切换的花费（10纳秒 ~ 1微秒）
        while (!owner.compareAndSet(null, t)) {
            System.out.println("自旋了" + System.currentTimeMillis());
        }

    }

    public void unlock(){
        Thread t = Thread.currentThread();
        //只有持有锁的线程才能解锁
        if (t == owner.get()) {
            if (count > 0) {
                --count;
            } else {
                //此处无需CAS操作，因为没有竞争，因为只有线程持有者才能解锁
                owner.set(null);
            }

        }

    }

}