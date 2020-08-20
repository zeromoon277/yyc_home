package learn.yyc.test.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/23 0023 下午 17:45
 */
public class ConditionDemo {


    public static void main(String[] args) {
        Product product = new Product();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Thread threadp = new Thread(() -> {
            while (true) {
                try {
                    reentrantLock.lock();
                    int count = product.getCount();
                    if (count > 0) {
                        product.sub();
                    } else {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    reentrantLock.lock();
                    product.add();
                    product.add();
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });

        thread.start();
        threadp.start();


    }

    static class Product {
        private int count = 0;

        public Product() {
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void add() {
            count++;
            System.out.println("生产一条");
        }

        public void sub() {
            count--;
            System.out.println("消费一条");
        }
    }
}
