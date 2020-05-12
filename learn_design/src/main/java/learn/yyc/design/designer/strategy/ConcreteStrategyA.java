package learn.yyc.design.designer.strategy;

/**
 * 策略模式-具体策略角色：A 不打折
 */
public class ConcreteStrategyA extends Strategy {

	@Override
	public double algorithm(double price) {
		return price;
	}

}
