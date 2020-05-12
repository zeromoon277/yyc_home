package learn.yyc.design.designer.strategy;

/**
 * 策略模式-上下文角色
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public double getResult(double price) {
		return strategy.algorithm(price);
	}
}
