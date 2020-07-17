package learn.yyc.test.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/29 0029 上午 11:23
 */
public class ThreadPrint {
    static int count = 0;
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Condition ca = lock.newCondition();
        Condition cb = lock.newCondition();
        Condition cc = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (count % 2 != 0){
                        ca.await();
                    }
                    System.out.println("A");
                    count++;
                    cb.signal();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }


        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (count % 2 != 1){
                        cb.await();
                    }
                    System.out.println("B");
                    count++;
                    ca.signal();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });


        thread1.start();
        Thread.sleep(100);

        thread2.start();

    }
}
