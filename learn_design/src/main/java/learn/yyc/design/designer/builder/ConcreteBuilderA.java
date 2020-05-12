package learn.yyc.design.designer.builder;

/**
 * 建造者模式-具体建造者角色：A
 */
public class ConcreteBuilderA extends Builder {

	private Product product = new Product();

	@Override
	public void buildPartOne() {
		product.setPartOne("部件：A-1");
	}

	@Override
	public void buildPartTwo() {
		product.setPartTwo("部件：A-2");
	}

	@Override
	public Product getProduct() {
		this.buildPartOne();
		this.buildPartTwo();
		return product;
	}

}
