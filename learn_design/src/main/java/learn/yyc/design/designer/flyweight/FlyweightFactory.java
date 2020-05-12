package learn.yyc.design.designer.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式-享元工厂角色
 */
public class FlyweightFactory {
	private Map<String,Flyweight> flyweightCache = new HashMap<String,Flyweight>();

	public Flyweight factory(String externalState){
		Flyweight flyweight = flyweightCache.get(externalState);
		if (flyweight == null) {
			flyweight = new ConcreteFlyweight(externalState);
			flyweightCache.put(externalState, flyweight);
		}
		return flyweight;
	}

}
