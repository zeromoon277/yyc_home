package learn.yyc.design.designer.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器模式-环境-Context角色：定义从变量到布尔值的一个映射
 */
public class Context {

	private Map<Variable,Boolean> map = new HashMap<Variable,Boolean>();

	public void assign(Variable var , boolean value){
        map.put(var, new Boolean(value));
    }

	public boolean lookup(Variable var) throws IllegalArgumentException{
        Boolean value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
