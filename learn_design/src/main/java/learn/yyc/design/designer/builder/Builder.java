package learn.yyc.design.designer.builder;

/**
 * 建造者模式-抽象建造者角色：提供建造产品的部件和获取完整产品的抽象方法
 */
public abstract class Builder {

	public abstract void buildPartOne();
	public abstract void buildPartTwo();

	public abstract Product getProduct();
}
