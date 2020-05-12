package learn.yyc.design.designer.command;

/**
 * 命令模式：抽象命令角色，命令超类，声明了一个给所有具体命令类的抽象接口。子类引用接收者角色
 * 例：定义抽象的执行命令方法。
 */
public abstract class Command {

	public abstract void excute();

}
