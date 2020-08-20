package learn.yyc.design.designer.iterator.demo;

import learn.yyc.design.designer.iterator.ConcreteAggregate;
import learn.yyc.design.designer.iterator.Iterator;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/17 0017 上午 11:31
 */
public class TestIterator {
    public static void main(String[] args) {
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        concreteAggregate.add("a");
        concreteAggregate.add("b");
        concreteAggregate.add("c");
        System.out.println(concreteAggregate.getSize());
        Iterator iterator = concreteAggregate.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
