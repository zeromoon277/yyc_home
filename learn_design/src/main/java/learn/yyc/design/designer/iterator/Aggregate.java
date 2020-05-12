package learn.yyc.design.designer.iterator;

/**
 * 迭代器模式-抽象容器角色：一般是一个接口，提供一个iterator()方法，例如java中的Collection接口，List接口，Set接口等
 */
public interface Aggregate {

	public void add(Object obj);
	public Object get(int index);
	public Object remove(int index);
	public Iterator getIterator();
	public int getSize();

}
