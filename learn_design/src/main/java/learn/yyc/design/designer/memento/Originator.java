package learn.yyc.design.designer.memento;

/**
 * 备忘录模式：发起者角色：负责创建一个备忘录用以记录当前时刻它的内部状态，并可以使用备忘录恢复内部状态。
 */
public class Originator {
	private String name;
	private int age;
	
	public Originator(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//进行备份操作，并返回一个备忘录对象
    public Memento backUp(){
        return new Memento(this);
    }
    //进行数据恢复，恢复成备忘录中对象的值
    public void recovery(Memento memento){
        this.name=memento.getName();
        this.age=memento.getAge();
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

	@Override
	public String toString() {
		return "Originator [name=" + name + ", age=" + age + "]";
	}
}
