package learn.yyc.design.designer.composite;



/**
 * 组合模式-叶节点角色-Leaf：叶子对象，没有子节点。
 * 例：文件系统文件,继承Component角色，没有子节点不需要实现添加，删除抽象方法。
 */
public class Leaf extends Component {

	public Leaf(String fileName) {
		super(fileName);
	}

	@Override
	public void add(Component component) {
		System.err.println("Cannot add to a leaf");
	}

	@Override
	public void delete(Component component) {
		System.err.println("Cannot remove from a leaf");
	}

	@Override
	public void display(int depth) {
		System.out.println(this.repeatChar('-', depth) + " " + fileName);
	}

	private String repeatChar(char c, int depth) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<depth; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
}
