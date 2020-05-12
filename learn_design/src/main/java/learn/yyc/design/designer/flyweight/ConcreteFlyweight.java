package learn.yyc.design.designer.flyweight;

/**
 * 享元模式-具体享元角色类
 */
public class ConcreteFlyweight implements Flyweight {

	private String internalState;

	public ConcreteFlyweight(String internalState) {
		super();
		this.internalState = internalState;
	}

	public void operation(String externalState) {
		System.out.println("Intrinsic State = " + this.internalState);
        System.out.println("Extrinsic State = " + externalState);
	}

}
