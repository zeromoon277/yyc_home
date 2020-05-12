package learn.yyc.design.designer.interpreter;

/**
 * 解释器模式-终结符表达式-Terminal Expression角色：一个Variable对象代表一个字符串变量
 */
public class Variable extends Expression {

	private String stringValue;

	public Variable(String stringValue) {
		super();
		this.stringValue = stringValue;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Variable) {
			Variable variable = (Variable) obj;
            return this.stringValue.equals(variable.stringValue);
        }
        return false;
	}

	@Override
	public String toString() {
		return stringValue;
	}

	@Override
	public boolean interpret(Context context) {
		return context.lookup(this);
	}
}
