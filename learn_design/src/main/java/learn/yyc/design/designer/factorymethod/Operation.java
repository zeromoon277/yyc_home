package learn.yyc.design.designer.factorymethod;

/**
 * 工厂方法模式-抽象产品-Product角色：运算符超类
 */
public abstract class Operation {

	protected double numberA;
	protected double numberB;

	public void setNumberA(double numberA) {
		this.numberA = numberA;
	}
	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}

	public abstract double getResult();
}
