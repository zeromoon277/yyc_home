package learn.yyc.design.designer.abstractfactory;

/**
 * 抽象工厂模式-具体产品角色
 * 例：苹果，实现榨汁方法
 */
public class Apple implements Fruit {

	public void juicing() {
		System.out.println("榨苹果汁");
	}

}
