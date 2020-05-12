package learn.yyc.design.designer.facade;

/**
 * 外观模式-门面角色：与子系统是组合关系，对子系统提供统一的接口，是结构型模式
 */
public class Facade {

	private SubSystemA systemA;
	private SubSystemB systemB;
	private SubSystemC systemC;
	private SubSystemD systemD;
	public Facade() {
		super();
		this.systemA = new SubSystemA();
		this.systemB = new SubSystemB();
		this.systemC = new SubSystemC();
		this.systemD = new SubSystemD();
	}

	public void methodA() {
		systemA.methodA();
		systemC.methodC();
	}
	
	public void methodB() {
		systemB.methodB();
		systemD.methodD();
	}
}
