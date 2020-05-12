package learn.yyc.design.designer.abstractfactory;

/**
 * 抽象工厂模式-具体产品角色
 * 例：橙子，实现榨汁方法
 */
public class Orange implements Fruit {

	@Override
	public void juicing() {
		System.out.println("榨橙汁");
	}

}
