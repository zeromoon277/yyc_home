package learn.yyc.design.designer.command;

/**
 * 命令模式：接收者角色-Receiver，负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 * 例：灯，执行开灯，关灯操作
 */
public class LightReceiver {

	public void turnOn() {
		System.out.println("The light is on!");
	}
	
	public void turnOff() {
		System.out.println("The light is off!");
	}
}
