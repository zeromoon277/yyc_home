package learn.yyc.test.demo.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/17 0017 下午 18:12
 */
public class SetDemo {

    @Test
    public void testSet(){
        Set<Persion> testSet = new HashSet<>();

        Persion p = new Persion(1);

        Persion p2 = new Persion(1);

        System.out.println(p == p2);
        System.out.println(p.equals(p2));

        testSet.add(p);
        testSet.add(p2);

        System.out.println(123);

    }
}
