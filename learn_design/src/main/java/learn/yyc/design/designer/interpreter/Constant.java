package learn.yyc.design.designer.interpreter;

/**
 * 解释器模式-终结符表达式-Terminal Expression角色：一个Constant对象代表一个布尔常量
 */
public class Constant extends Expression {

	private boolean booleanValue;

	public Constant(boolean booleanValue) {
		super();
		this.booleanValue = booleanValue;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Constant){
			Constant constant = (Constant) obj;
            return this.booleanValue == constant.booleanValue;
        }
        return false;
	}

	@Override
	public String toString() {
		return new Boolean(booleanValue).toString();
	}

	@Override
	public boolean interpret(Context context) {
		return booleanValue;
	}
}
