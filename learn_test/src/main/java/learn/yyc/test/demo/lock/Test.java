package learn.yyc.test.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/3 0003 上午 10:20
 */
public class Test {
    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            printThreadName();
        });
        t1.setName("---T1---");


        Thread t2 = new Thread(()->{
            printThreadName();
        });
        t2.setName("---T2---");

        t1.start();
        t2.start();
    }


    public static synchronized void printThreadName(){

        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
}
