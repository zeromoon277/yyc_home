package learn.yyc.design.designer.iterator;


/**
 * 迭代器模式-具体容器角色：就是抽象容器的具体实现类，比如List接口的有序列表实现ArrayList，List接口的链表实现LinkList，Set接口的哈希列表的实现HashSet等。
 */
public class ConcreteAggregate implements Aggregate {

	private Object[] aggregate;
	private int size;
	protected int index;

	public ConcreteAggregate() {
		super();
		aggregate = new Object[100];
	}

	@Override
	public Iterator getIterator() {
		return new ConcreteIterator(this);
	}

	@Override
	public void add(Object obj) {
		aggregate[index++] = obj;
		size++;
	}

	@Override
	public Object get(int index) {
		return aggregate[index];
	}

	@Override
	public Object remove(int index) {
		this.index++;
		Object oldValue = aggregate[index];
		int numMoved = aggregate.length - index - 1;
		if (numMoved > 0)
		    System.arraycopy(aggregate, index+1, aggregate, index, numMoved);
		aggregate[--this.size] = null; // Let gc do its work
		return oldValue;
	}

	@Override
	public int getSize() {
		return size;
	}

}
