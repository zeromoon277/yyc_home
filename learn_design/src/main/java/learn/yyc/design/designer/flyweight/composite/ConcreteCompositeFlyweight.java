package learn.yyc.design.designer.flyweight.composite;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元模式-复合具体享元角色类
 */
public class ConcreteCompositeFlyweight implements Flyweight {

	private Map<String,Flyweight> compositeFlyweightCache = new HashMap<String,Flyweight>();

	public void add(String key, Flyweight value) {
		compositeFlyweightCache.put(key, value);
	}

	@Override
	public void operation(String externalState) {
		for (String internalState : compositeFlyweightCache.keySet()) {
			Flyweight flyweight = compositeFlyweightCache.get(internalState);
			flyweight.operation(externalState);
		}
	}

}
