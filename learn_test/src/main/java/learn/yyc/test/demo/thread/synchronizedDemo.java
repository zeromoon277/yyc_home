package learn.yyc.test.demo.thread;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/23 0023 下午 14:08
 */
public class synchronizedDemo {

    private static volatile int a = 0;


    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{
            count();
        });
        Thread t1 = new Thread(()->{
            count();
        });
        Thread t2 = new Thread(()->{
            count();
        });

        t.start();
        t1.start();
        t2.start();

        Thread.sleep(500);
        System.out.println(a);
    }


    private static void count(){
        for (int i = 0; i < 1000000; i++) {
            a++;
        }
    }
}
