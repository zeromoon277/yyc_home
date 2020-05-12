package learn.yyc.design.designer.flyweight;

/**
 * 享元模式-抽象享元角色
 */
public interface Flyweight {

	//一个示意性方法，参数state是外蕴状态
	public void operation(String externalState);

}
