package learn.yyc.design.designer.decorator;

/**
 * 装饰模式-抽象装饰角色：持有构件Component对象实例，
 */
public abstract class Decorator extends Component {

	private Component component;

	public Decorator(Component component) {
		super();
		this.component = component;
	}

	@Override
	public void operation() {
		component.operation();
		
	}

}
