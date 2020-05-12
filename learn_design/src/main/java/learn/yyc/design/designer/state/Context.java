package learn.yyc.design.designer.state;

/**
 * 状态模式-Context角色：维护一个具体状态类来定义当前状态。
 * 并且提供当前状态对应的行为，行为结束后状态改为下一个状态。
 */
public class Context {

	private State state;

	public Context(State state) {
		super();
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void request() {
		state.Handle(this);
	}
}
