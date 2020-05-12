package learn.yyc.design.designer.singleton;

/**
 * 单例模式：保证一个类仅有一个实例，并提供全局获取方法。
 * 懒汉式：获取实例时初始化(类加载时不生成实例，第一次获取实例时才会生成实例) 饿汉式：声明时初始化，获取实例方法中直接返回(类加载时已经生成实例)。
 */
public class Singleton {

	private static Singleton singleton = null;

	private Singleton() {}

	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}