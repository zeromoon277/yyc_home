package learn.yyc.test.demo.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/3 0003 下午 12:01
 */
public class TestPrak {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            printThreadName();
        });
        t1.setName("---T1---");

        t1.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main-----1");
        LockSupport.unpark(t1);
    }


    public static  void printThreadName(){

        System.out.println(Thread.currentThread().getName());
        LockSupport.park();
        System.out.println("--end");

    }
}
