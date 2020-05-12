package learn.yyc.design.designer.visitor;

/**
 * 访问者模式：Concrete Visitor-具体访问者角色 A，实现访问元素的动作，实现一个访问者对于一个具体的元素的操作。
 */
public class VisitorA implements Visitor {

	@Override
	public void visit(ElementA elementA) {
		System.out.println("Execute VisitorA visit" + elementA.getElementName() + "`s method!");
	}

	@Override
	public void visit(ElementB elementB) {
		System.out.println("Execute VisitorA visit" + elementB.getElementName() + "`s method!");
	}

}
