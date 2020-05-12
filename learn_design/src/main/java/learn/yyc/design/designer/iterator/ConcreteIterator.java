package learn.yyc.design.designer.iterator;



/**
 * 迭代器模式-具体迭代器角色：实现迭代器接口中定义的方法，完成集合的迭代。
 */
public class ConcreteIterator implements Iterator {

	private Aggregate aggregate = null;
	private int index;

	public ConcreteIterator(Aggregate aggregate) {
		super();
		this.aggregate = aggregate;
	}

	@Override
	public boolean hasNext() {
		return index < aggregate.getSize();
	}

	@Override
	public Object next() {
		return aggregate.get(index++);
	}

	@Override
	public void remove() {
		aggregate.remove(--index);
		
	}

}
