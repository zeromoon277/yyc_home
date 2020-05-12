package learn.yyc.design.designer.factorysimple;

/**
 * 简单工厂模式-产品工厂角色
 */
public class OperationFactory {

	public static Operation createOperation(String operate) {
		if ("+".equals(operate)) {
			return new PlusOperation();
		} else if ("-".equals(operate)) {
			return new MinusOperation();
		}
		return null;
	}
}
