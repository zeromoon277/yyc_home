package learn.yyc.design.designer.memento;

/**
 * 备忘录模式：备忘录角色：负责存储Originator对象的内部状态，并可以防止Originator以外的其他对象访问备忘录。
 */
public class Memento {

	private String name;
	private int age;

	public Memento(Originator originator) {
		super();
		this.name = originator.getName();
		this.age = originator.getAge();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
