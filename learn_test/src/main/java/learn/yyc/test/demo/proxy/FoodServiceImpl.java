package learn.yyc.test.demo.proxy;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/16 0016 下午 14:56
 */
public class FoodServiceImpl implements FoodService{
    @Override
    public void makeNoodle() {
        System.out.println("make noodle");
    }

    @Override
    public void makeChicken() {
        System.out.println("make Chicken");
    }

    @Override
    public void makeMore(String more) {
        System.out.println("make " + more);
    }
}
