package learn.yyc.design.designer.mediator;

/**
 * 中介者模式-抽象同事类
 */
public abstract class Colleague {

	protected Mediator mediator;

	public Colleague(Mediator mediator) {
		super();
		this.mediator = mediator;
	}

}
