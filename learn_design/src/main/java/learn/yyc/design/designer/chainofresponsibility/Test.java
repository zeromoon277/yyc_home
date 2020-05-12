package learn.yyc.design.designer.chainofresponsibility;

/**
 * Created by Administrator on 2019/3/14 0014.
 */
public class Test {
    public static void main(String[] args) {
        Handler handler = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();
        Level level = Level.Level_C;
        handler.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);
        handler.handleRequest(level);

    }
}
