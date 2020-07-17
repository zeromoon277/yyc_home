package learn.yyc.test.demo.thread;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/30 0030 下午 14:23
 */
public class PrintBean {

    private String value;

    public PrintBean(String value) {
        this.value = value;
    }

    public void print(){
        System.out.println(value);
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
