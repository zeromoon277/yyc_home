package learn.yyc.design.designer.strategy;

/**
 * 策略模式-具体策略角色：C 打8折
 */
public class ConcreteStrategyC extends Strategy {

	@Override
	public double algorithm(double price) {
		return price * 0.8;
	}

}
