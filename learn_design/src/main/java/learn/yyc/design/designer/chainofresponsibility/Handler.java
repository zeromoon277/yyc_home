package learn.yyc.design.designer.chainofresponsibility;

/**
 * 责任链模式：抽象处理者角色-Handler，与子类-具体继任者角色是聚合关系给出了具体子类对下家的引用。抽象方法规范子类处理请求的操作。
 */
public abstract class Handler {

	protected Handler successor;

	public Handler getSuccessor() {
		return successor;
	}

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	public abstract void handleRequest(Level level);
}
