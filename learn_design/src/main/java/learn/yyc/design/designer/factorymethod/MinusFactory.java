package learn.yyc.design.designer.factorymethod;

/**
 * 工厂方法模式-创建减法工厂角色
 */
public class MinusFactory implements OperationFactory {

	@Override
	public Operation createOperation() {
		return new MinusOperation();
	}

}
