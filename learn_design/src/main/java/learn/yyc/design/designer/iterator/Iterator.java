package learn.yyc.design.designer.iterator;

/**
 * 迭代器模式-抽象迭代器角色：定义遍历元素所需要的取得下一个元素的方法next()，判断是否遍历结束的方法hasNext()，移出当前对象的方法remove()。
 */
public interface Iterator {

	public boolean hasNext();
	public Object next();
	public void remove();
}
