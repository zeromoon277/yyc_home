package learn.yyc.design.designer.bridge;

/**
 * 桥接模式：具体实现类角色 - B：实现抽象实现类角色的接口。
 * 例：实现方子类 - B
 */
public class ConcreteImplementorB implements Implementor {

	@Override
	public void operationImpl() {
		System.out.println("Implementor B`s operationImpl method!");
	}

}
