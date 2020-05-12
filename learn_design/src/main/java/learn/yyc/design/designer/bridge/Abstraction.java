package learn.yyc.design.designer.bridge;

/**
 * 桥接模式：抽象类角色：聚合抽象实现类角色，既可以包含抽象业务方法，也可以包含具体业务方法。
 * 抽象类角色表示另一个分类的超类与抽象实现类角色是聚合/合成关系，构造函数接口抽象接口的具体子类。调用抽象接口子类方法来实现。
 * 例：抽象方超类
 */
public abstract class Abstraction {

	protected Implementor implementor;

	public Abstraction(Implementor implementor) {
		super();
		this.implementor = implementor;
	}

	public void operation() {
		implementor.operationImpl();
	}

	public abstract void refinedOperation();
}
