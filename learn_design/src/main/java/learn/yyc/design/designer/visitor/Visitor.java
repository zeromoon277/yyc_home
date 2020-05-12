package learn.yyc.design.designer.visitor;


/**
 * 访问者模式：Visitor-抽象访问者角色，抽象出访问元素的动作，在重载的visit函数中声明访问者可以访问的对象。
 */
public interface Visitor {

	public void visit(ElementA elementA);

	public void visit(ElementB elementB);

}
