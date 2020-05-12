package learn.yyc.design.designer.factorymethod;

/**
 * 工厂方法模式-创建加法工厂角色
 */
public class PlusFactory implements OperationFactory {

	@Override
	public Operation createOperation() {
		return new PlusOperation();
	}

}
