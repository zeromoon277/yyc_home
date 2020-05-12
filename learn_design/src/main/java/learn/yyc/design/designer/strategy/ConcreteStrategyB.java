package learn.yyc.design.designer.strategy;

/**
 * 策略模式-具体策略角色：B 打9折
 */
public class ConcreteStrategyB extends Strategy {

	@Override
	public double algorithm(double price) {
		return price * 0.9;
	}

}
