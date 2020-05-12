package learn.yyc.design.designer.command;


/**
 * 命令模式：请求者角色-Invoker，与命令角色是聚合关系。负责调用命令对象执行请求，相关的方法叫做行动方法。
 */
public class Invoker {

	private Command commandOn;
	private Command commandOff;

	public Invoker(Command commandOn, Command commandOff) {
		super();
		this.commandOn = commandOn;
		this.commandOff = commandOff;
	}

	public void turnOn() {
		commandOn.excute();
	}

	public void turnOff() {
		commandOff.excute();
	}

}
