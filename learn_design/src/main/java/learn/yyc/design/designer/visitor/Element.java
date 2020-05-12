package learn.yyc.design.designer.visitor;

/**
 * 访问者模式：Visitor-抽象元素，定义一个接受访问的操作，其参数为访问者.
 * 			     声明具有访问该类型元素权限的访问者的类型。
 */
public abstract class Element {

	String elementName;

	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public abstract void accept(Visitor visitor);
}
