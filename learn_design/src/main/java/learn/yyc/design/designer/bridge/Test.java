package learn.yyc.design.designer.bridge;

/**
 * Created by Administrator on 2019/3/14 0014.
 */
public class Test {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorB();
        RefinedAbstraction refinedAbstraction = new RefinedAbstraction(implementor);
        refinedAbstraction.implementor.operationImpl();
        refinedAbstraction.refinedOperation();
    }
}
