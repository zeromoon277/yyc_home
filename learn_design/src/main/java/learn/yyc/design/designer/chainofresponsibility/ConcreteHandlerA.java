package learn.yyc.design.designer.chainofresponsibility;

/**
 * 责任链模式：继任者角色-Successor，与子类-具体继任者角色是聚合关系给出了具体子类对下家的引用。抽象方法规范子类处理请求的操作。
 */
public class ConcreteHandlerA extends Handler {

	@Override
	public void handleRequest(Level level) {
		if (level.equals(Level.Level_A)) {
			System.out.println("Handler A 处理了请求！");
		} else if (getSuccessor() != null) {
			getSuccessor().handleRequest(level);
		} else {
			System.err.println("该请求没有匹配到对应的继任者！");
		}
	}

}
