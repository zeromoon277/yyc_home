package learn.yyc.design.designer.observer;


/**
 * 观察者模式-具体目标(具体被观察者角色)：继承主题，当发生变化时通知观察者
 * 例：小偷嫌疑人，盗窃时通知监督警察实施抓捕
 */
public class SharpSuspects extends Suspects {

	@Override
	public void crime() {
		System.out.println("小偷实施盗窃！");
		notifyObservers("小偷");
	}
}
