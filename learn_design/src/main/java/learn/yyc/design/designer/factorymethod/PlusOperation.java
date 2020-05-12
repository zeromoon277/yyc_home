package learn.yyc.design.designer.factorymethod;

/**
 * 工厂方法模式-具体产品-Product角色：加法运算
 */
public class PlusOperation extends Operation {

	@Override
	public double getResult() {
		return numberA + numberB;
	}

}
