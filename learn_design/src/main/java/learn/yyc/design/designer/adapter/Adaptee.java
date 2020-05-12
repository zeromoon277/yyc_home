package learn.yyc.design.designer.adapter;

/**
 * 适配器模式-适配者角色：被适配的具体实现类。
 */
public class Adaptee implements IAdaptee {

	@Override
	public void oldRequest() {
		System.out.println("适配者的实现方法！");
	}

}
