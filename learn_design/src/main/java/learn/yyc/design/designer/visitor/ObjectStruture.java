package learn.yyc.design.designer.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 访问者模式：ObjectStruture-对象结构角色，
 * 			  可以遍历结构中的所有元素，提供一个接口让访问者对象都可以访问每一个元素。 
 */
public class ObjectStruture {
	public static List<Element> elementList = new ArrayList<Element>();

	public void addElement(Element element) {
		elementList.add(element);
	}
	
	public void removeElement(Element element) {
		elementList.remove(element);
	}

	public void accept(Visitor visitor) {
		Iterator<Element> iterator = elementList.iterator();
		while(iterator.hasNext()) {
			iterator.next().accept(visitor);
		}
	}
}
