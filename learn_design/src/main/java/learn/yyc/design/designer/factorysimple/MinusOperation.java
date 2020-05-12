package learn.yyc.design.designer.factorysimple;

/**
 * 简单工厂模式-具体产品-Product角色：减法运算
 */
public class MinusOperation extends Operation {

	@Override
	public double getResult() {
		return numberA - numberB;
	}

}
