package learn.yyc.design.designer.proxy;

/**
 * 代理模式-真实主题角色：实现抽象主题接口
 */
public class RealSubject extends Subject {

	@Override
	public void request() {
		System.out.println("真实主题实现请求！");
	}

}
