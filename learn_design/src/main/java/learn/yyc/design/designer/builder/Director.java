package learn.yyc.design.designer.builder;

/**
 * 建造者模式-指挥者角色：与具体建造者角色是聚合关系，负责构建产品
 */
public class Director {

	public void construct(Builder builder) {
		System.out.println("director 指挥 builder进行构建产品");
		builder.buildPartOne();
		builder.buildPartTwo();
	}

}
