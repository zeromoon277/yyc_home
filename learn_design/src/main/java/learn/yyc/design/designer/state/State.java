package learn.yyc.design.designer.state;

/**
 * 状态模式-抽象状态角色：定义一个封装与Context的一个特定状态相关行为抽象接口
 */
public abstract class State {

	public abstract void Handle(Context context);

}
