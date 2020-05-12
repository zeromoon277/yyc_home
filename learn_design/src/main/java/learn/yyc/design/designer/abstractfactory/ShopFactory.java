package learn.yyc.design.designer.abstractfactory;

/**
 * 抽象工厂模式-抽象工厂角色
 * 例：商店，提供所有肉类和水果类的方法
 */
public interface ShopFactory {

	public Fruit buyFruit();
	public Meat buyMeat();

}
