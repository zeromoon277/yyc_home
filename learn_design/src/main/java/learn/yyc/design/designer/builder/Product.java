package learn.yyc.design.designer.builder;

/**
 * 建造者模式-产品角色
 */
public class Product {

	private String partOne;
	private String partTwo;

	public String getPartOne() {
		return partOne;
	}
	public void setPartOne(String partOne) {
		this.partOne = partOne;
	}
	public String getPartTwo() {
		return partTwo;
	}
	public void setPartTwo(String partTwo) {
		this.partTwo = partTwo;
	}

	@Override
	public String toString() {
		return "Product [partOne=" + partOne + ", partTwo=" + partTwo + "]";
	}

}
