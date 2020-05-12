package learn.yyc.design.designer.flyweight.composite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复合享元模式-享元工厂角色
 */
public class CompositeFlyweightFactory {
	private Map<String,Flyweight> flyweightCache = new HashMap<String,Flyweight>();

	public Flyweight factory(List<String> externalStateList){
		ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
		for (String externalState : externalStateList) {
			compositeFly.add(externalState, this.factory(externalState));
		}
		return compositeFly;
	}
	
	public Flyweight factory(String externalState){
		Flyweight flyweight = flyweightCache.get(externalState);
		if (flyweight == null) {
			flyweight = new ConcreteFlyweight(externalState);
			flyweightCache.put(externalState, flyweight);
		}
		return flyweight;
	}

}
