package learn.yyc.design.designer.builder;

/**
 * 建造者模式-具体建造者角色：B
 */
public class ConcreteBuilderB extends Builder {

	private Product product = new Product();

	@Override
	public void buildPartOne() {
		product.setPartOne("部件：B-1");
	}

	@Override
	public void buildPartTwo() {
		product.setPartTwo("部件：B-2");
	}

	@Override
	public Product getProduct() {
		return product;
	}

}
