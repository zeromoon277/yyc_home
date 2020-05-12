package learn.yyc.design.designer.observer;

/**
 * 观察者模式-抽象观察者
 * 例：抽象警察，提供抽象的抓捕嫌疑人方法
 */
public interface PoliceObserver {

	public void arrest(String suspects);

}
