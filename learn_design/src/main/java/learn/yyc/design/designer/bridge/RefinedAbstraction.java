package learn.yyc.design.designer.bridge;

/**
 * 桥接模式：扩充抽象类角色：继承抽象类角色，既可以包含抽象业务方法，也可以包含具体业务方法。
 * 例：抽象方扩充类，继承抽象方超类。在原有抽象方业务基础上可以扩充新业务，起扩展作用。
 */
public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}

	@Override
	public void refinedOperation() {
		System.out.println("Refined Abstraction`s refinedOperation method.");
	}

}
