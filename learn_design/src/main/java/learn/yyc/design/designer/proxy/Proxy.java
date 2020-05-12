package learn.yyc.design.designer.proxy;

/**
 * 代理模式-代理角色：聚合真实主题角色，调用真实主题方法实现抽象主题方法。
 */
public class Proxy extends Subject {

	private RealSubject realSubject;
	
	public Proxy(RealSubject realSubject) {
		super();
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		realSubject.request();
	}

}
