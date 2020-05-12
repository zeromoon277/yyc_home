package learn.yyc.design.designer.templatemethod;

/**
 * 模板方法模式-具体模板角色：软件模板
 */
public class SoftwareTemplate extends ProjectTemplate {

	@Override
	protected void dev() {
		System.out.println("开发软件中......");
	}

	@Override
	protected boolean needTest() {
		return false;//紧急，略过测试环节
	}

}
