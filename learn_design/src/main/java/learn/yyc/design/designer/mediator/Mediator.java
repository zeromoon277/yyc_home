package learn.yyc.design.designer.mediator;

/**
 * 中介者模式：抽象中介者，定义同事对象到中介者对象的接口。定义一个抽象的发送消息方法，得到同事对象和发送信息。
 */
public abstract class Mediator {

	abstract void Send(Colleague colleague, String message);

}
