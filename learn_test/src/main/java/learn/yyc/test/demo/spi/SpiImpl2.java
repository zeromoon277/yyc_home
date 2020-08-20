package learn.yyc.test.demo.spi;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/10 0010 下午 17:05
 */
public class SpiImpl2 implements SPIService{
    @Override
    public void execute() {
        System.out.println("SpiImpl2.execute()");
    }
}
