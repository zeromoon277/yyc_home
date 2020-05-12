package learn.yyc.design.designer.templatemethod;

/**
 * 模板方法模式-具体模板角色：游戏模板
 */
public class GameTemplate extends ProjectTemplate {

	@Override
	protected void dev() {
		System.out.println("开发游戏中......");
	}

}
