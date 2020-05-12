package learn.yyc.design.designer.mediator;

/**
 * 中介者模式：具体同事类-A，继承抽象同事类，通过构造函数注册具体中介者对象，使每个具体同事类都与中介建立联系。(每个具体同事类相对独立)
 */
public class ConcreteColleagueA extends Colleague {

	public ConcreteColleagueA(Mediator mediator) {
		super(mediator);
	}

	public String Send(String message) {
		mediator.Send(this, message);
		return message;
	}

	public String Notify(String message) {
		System.out.println("同事A得到的消息：" + message);
		return message;
	}
}
