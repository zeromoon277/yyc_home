package learn.yyc.design.designer.bridge;

/**
 * 桥接模式：具体实现类角色 - A：实现抽象实现类角色的接口。
 * 例：实现方子类 - A
 */
public class ConcreteImplementorA implements Implementor {

	@Override
	public void operationImpl() {
		System.out.println("Implementor A`s operationImpl method!");
	}

}
