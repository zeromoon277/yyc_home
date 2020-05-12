package learn.yyc.design.designer.abstractfactory;

/**
 * 抽象工厂模式-具体工厂角色
 * 例：超市 A，只卖苹果和猪肉
 */
public class MarketFactoryA implements ShopFactory {

	@Override
	public Fruit buyFruit() {
		return new Apple();
	}

	@Override
	public Meat buyMeat() {
		return new Pork();
	}

}
