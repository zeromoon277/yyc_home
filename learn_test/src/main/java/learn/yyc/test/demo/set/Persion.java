package learn.yyc.test.demo.set;

import java.util.Random;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/17 0017 下午 18:16
 */
public class Persion {
    private int a;


    public Persion(int a) {
        this.a = a;
    }

    @Override
    public int hashCode() {
        Random random = new Random();

        return random.nextInt(100);
    }

    @Override
    public String toString() {
        return "A";

    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
