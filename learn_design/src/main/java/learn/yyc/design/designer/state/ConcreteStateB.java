package learn.yyc.design.designer.state;

/**
 * 状态模式-具体状态角色：继承或实现抽象状态角色，实现当前状态对应的行为方法。
 */
public class ConcreteStateB extends State {

	@Override
	public void Handle(Context context) {
		System.out.println("执行状态 B 对应的行为！");
	}

}
