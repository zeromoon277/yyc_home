package learn.yyc.design.designer.decorator;

public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		this.decorateMethodB();
		super.operation();
	}

	public void decorateMethodB() {
		System.out.println("具体装饰方法-B执行了！");
	}

}
