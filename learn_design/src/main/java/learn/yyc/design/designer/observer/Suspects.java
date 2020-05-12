package learn.yyc.design.designer.observer;

import java.util.Iterator;
import java.util.Vector;

/**
 * 观察者模式-目标(主题、抽象被观察者角色)：聚合所有具体观察者实例。提供添加、删除观察者集合方法，还有通知方法
 * 例：嫌疑人，被多名监督警察盯着。提供抽象的犯罪方法，子类实现犯罪方法时调用通知方法通知警察
 */
public abstract class Suspects {

	private Vector<PoliceObserver> observers = new Vector<PoliceObserver>();
	
	public void registerObserver(PoliceObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(PoliceObserver observer) {
		observers.remove(observer);
	}

	public abstract void crime();
	
	public void notifyObservers(String suspects) {
		Iterator<PoliceObserver> i = observers.iterator();
		while (i.hasNext()) {
			PoliceObserver observer = i.next();
			observer.arrest(suspects);
		}
	}
}
