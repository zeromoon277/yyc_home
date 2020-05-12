package learn.yyc.design.designer.visitor;

/**
 * 访问者模式：Element-抽象元素 B，定义一个接受访问的操作，其参数为访问者.
 * 			     实现抽象元素类所声明的accept方法，通常都是visitor.visit(this)，基本上已经形成一种定式了。
 */
public class ElementB extends Element {

	public ElementB() {
		super();
		setElementName("Element_B");
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
