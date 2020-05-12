package learn.yyc.design.designer.mediator;

/**
 * 中介者模式-具体中介者：与同事是聚合关系，用一个中介对象来封装一系列同事对象的交互行为，是行为型模式
 */
public class ConcreteMediator extends Mediator {

	private ConcreteColleagueA colleagueA;
	private ConcreteColleagueB colleagueB;
	
	public void setColleague1(ConcreteColleagueA colleagueA) {
		this.colleagueA = colleagueA;
	}

	public void setColleague2(ConcreteColleagueB colleagueB) {
		this.colleagueB = colleagueB;
	}

	@Override
	void Send(Colleague colleague, String message) {
		if (colleague == colleagueA) {
			colleagueB.Notify(message);
		} else {
			colleagueA.Notify(message);
		}
	}

}
