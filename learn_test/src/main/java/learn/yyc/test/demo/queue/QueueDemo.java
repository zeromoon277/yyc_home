package learn.yyc.test.demo.queue;

import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/17 0017 下午 16:34
 */
public class QueueDemo {

    /**
     *     add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
     * 　　remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
     * 　　element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
     * 　　offer       添加一个元素并返回true       如果队列已满，则返回false
     * 　　poll         移除并返问队列头部的元素    如果队列为空，则返回null
     * 　　peek       返回队列头部的元素             如果队列为空，则返回null
     * 　　put         添加一个元素                      如果队列满，则阻塞
     * 　　take        移除并返回队列头部的元素     如果队列为空，则阻塞
     */
    @Data
    @Accessors(chain = true)
    class DataBean{
        private String index;
        private String data;
    }

    @Test
    /**
     * 一个由数组支持的有界队列
     * 在构造时需要指定容量， 并可以选择是否需要公平性，如果公平参数被设置true，
     * 等待时间最长的线程会优先得到处理（其实就是通过将ReentrantLock设置为true来 达到这种公平性的：
     * 即等待时间最长的线程会先操作）。
     * 通常，公平性会使你在性能上付出代价，只有在的确非常需要的时候再使用它。它是基于数组的阻塞循环队列，此队列按 FIFO（先进先出）原则对元素进行排序。
     */
    public void testArrayBlockingQueue(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        try {
            arrayBlockingQueue.put(new DataBean().setData("haha1").setIndex("1"));
            arrayBlockingQueue.put(new DataBean().setData("haha2").setIndex("2"));
            arrayBlockingQueue.put(new DataBean().setData("haha3").setIndex("3"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(arrayBlockingQueue.offer(new DataBean().setData("haha4").setIndex("4")));

    }

    @Test
    /**
     * 无界队列
     */
    public void testLinkedBlockingQueue (){
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue ();


    }

    @Test
    /**
     * ConcurrentLinkedQueue 是基于链接节点的、线程安全的队列。并发访问不需要同步。因为它在队列的尾部添加元素并从头部删除它们，所以只要不需要知道队列的大小，　　　　    　　
     * ConcurrentLinkedQueue 对公共集合的共享访问就可以工作得很好。收集关于队列大小的信息会很慢，需要遍历队列。
     */
    public void testConcurrentLinkedQueue (){
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue ();


    }


    @Test
    /**
     * 是一个带优先级的 队列，而不是先进先出队列。元素按优先级顺序被移除，
     * 该队列也没有上限（看了一下源码，PriorityBlockingQueue是对 PriorityQueue的再次包装，
     * 是基于堆数据结构的，而PriorityQueue是没有容量限制的，与ArrayList一样，所以在优先阻塞队列上put时是不会受阻的。
     * 虽然此队列逻辑上是无界的，但是由于资源被耗尽，所以试图执行添加操作可能会导致 OutOfMemoryError），
     * 但是如果队列为空，那么取元素的操作take就会阻塞，所以它的检索操作take是受阻的。另外，往入该队列中的元 素要具有比较能力。
     */
    public void testPriorityBlockingQueue (){
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
    }

    @Test
    /**
     * PriorityQueue 类实质上维护了一个有序列表。
     * 加入到 Queue 中的元素根据它们的天然排序（通过其 java.util.Comparable 实现）
     * 或者根据传递给构造函数的 java.util.Comparator 实现来定位
     */
    public void testPriorityQueue (){
        PriorityQueue priorityQueue = new PriorityQueue();

    }


    @Test
    /**
     * 一个由优先级堆支持的、基于时间的调度队列
     */
    public void testDelayQueue (){
        DelayQueue delayQueue = new DelayQueue();


    }
    @Test
    /**
     * 一个利用 BlockingQueue 接口的简单聚集（rendezvous）机制
     */
    public void testSynchronousQueue (){
        SynchronousQueue synchronousQueue = new SynchronousQueue();


    }




}
