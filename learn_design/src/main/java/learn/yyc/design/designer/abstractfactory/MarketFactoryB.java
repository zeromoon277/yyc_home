package learn.yyc.design.designer.abstractfactory;

/**
 * 抽象工厂模式-具体工厂角色
 * 例：超市 B，只卖橙子和牛肉
 */
public class MarketFactoryB implements ShopFactory {

	@Override
	public Fruit buyFruit() {
		return new Orange();
	}

	@Override
	public Meat buyMeat() {
		return new Beef();
	}

}
