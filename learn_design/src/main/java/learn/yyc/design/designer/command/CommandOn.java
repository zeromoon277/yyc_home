package learn.yyc.design.designer.command;

/**
 * 命令模式：具体命令角色，定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法。
 * 例：开灯命令，调用接收者的开灯操作实现开灯命令。
 */
public class CommandOn extends Command {

	private LightReceiver receiver;

	public CommandOn(LightReceiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void excute() {
		receiver.turnOn();
	}

}
