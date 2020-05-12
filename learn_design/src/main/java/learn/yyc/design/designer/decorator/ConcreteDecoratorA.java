package learn.yyc.design.designer.decorator;

public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		this.decorateMethodA();
		super.operation();
	}

	public void decorateMethodA() {
		System.out.println("具体装饰方法-A执行了！");
	}

}
