package learn.yyc.design.designer.templatemethod;

/**
 * 模板方法模式-抽象模板角色：final模板方法实现功能逻辑架构。定义私有基本操作-将公共部分提取到父类，定义抽象基本操作，让子类实现细节。
 */
public abstract class ProjectTemplate {

	protected abstract void dev();
	private void test() {
		System.out.println("项目测试中......");
	};
	private void open() {
		System.out.println("项目上线了！");
	};
	//模板方法
	public final void process() {
		this.dev();
		if (needTest()) {
			this.test();
		}
		this.open();
	}

	/**
	 * 钩子方法,protected权限可被子类覆盖，默认为返回true
	 */
	protected boolean needTest() {
		return true;
	}
}
