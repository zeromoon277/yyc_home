package learn.yyc.design.designer.decorator;

/**
 * 装饰模式-具体构件角色：被装饰者类
 */
public class ConcreteComponent extends Component {

	@Override
	public void operation() {
		System.out.println("被装饰者的方法执行了！");
	}

}
