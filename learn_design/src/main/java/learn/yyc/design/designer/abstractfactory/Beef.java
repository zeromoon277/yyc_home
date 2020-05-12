package learn.yyc.design.designer.abstractfactory;

/**
 * 抽象工厂模式-具体产品角色
 * 例：牛肉，实现烹饪方法
 */
public class Beef implements Meat {

	@Override
	public void cook() {
		System.out.println("煎牛排");
	}

}
