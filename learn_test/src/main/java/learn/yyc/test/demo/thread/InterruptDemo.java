package learn.yyc.test.demo.thread;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/22 0022 下午 15:40
 */
public class InterruptDemo {

    public static void main(String[] args) {

        //sleepThread睡眠1000ms
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        //busyThread一直执行死循环
        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true) ;
            }
        };

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();

        while (sleepThread.isInterrupted()) ;
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }

}
