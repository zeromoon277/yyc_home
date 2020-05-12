package learn.yyc.design.designer.adapter;

/**
 * 适配器模式-适配器角色：将源接口转换成目标接口，适配器引用适配者实现目标接口。
 * 将原有的IAdaptee接口与目标ITarget接口不一致，但实现方法相同时通过适配器将源接口转换成目标接口。
 * 类适配器模式：适配器继承适配者类调用父类方法来实现目标方法。
 * 对象适配器模式：适配器中聚合适配者来实现目标方法。
 */
public class Adapter implements ITarget {

	private IAdaptee adaptee;

	public Adapter(IAdaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.oldRequest();
	}

}
