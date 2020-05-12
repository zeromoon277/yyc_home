package learn.yyc.design.designer.composite;

/**
 * 组合模式-结构抽象角色-Component：组合中对象声明接口，用于访问和管理Component子部件。
 * 例：文件系统超类，文件名属性，提供添加、删除、显示抽象方法。
 */
public abstract class Component {

	protected String fileName;

	public Component(String fileName) {
		super();
		this.fileName = fileName;
	}

	public abstract void add(Component component);
	public abstract void delete(Component component);
	public abstract void display(int depth);

}
