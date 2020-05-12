package learn.yyc.design.designer.composite;

import java.util.ArrayList;
import java.util.List;


/**
 * 组合模式-枝节点角色-Composite：容器对象，定义有枝节点行为，用来存储子部件。
 * 例：文件系统文件夹,继承Component角色，聚和关系，实现显示、添加和删除枝/叶节点抽象方法。
 */
public class Composite extends Component {

	public Composite(String fileName) {
		super(fileName);
	}

	private List<Component> children = new ArrayList<Component>();

	@Override
	public void add(Component component) {
		children.add(component);
	}

	@Override
	public void delete(Component component) {
		children.remove(component);
	}

	@Override
	public void display(int depth) {
		System.out.println(this.repeatChar('-', depth) + " " + fileName);
		for (Component component : children) {
			component.display(depth + 1);
		}
	}

	private String repeatChar(char c, int depth) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<depth; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
}
