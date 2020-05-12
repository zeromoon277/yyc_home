package learn.yyc.design.designer.memento;

/**
 * 备忘录模式-管理者角色：负责管理备忘录类，示例只保存了一个备忘录对象，可以通过设置栈保存多个对象
 */
public class CareTaker {

	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
