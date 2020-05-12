package learn.yyc.design.designer.interpreter;

/**
 * 解释器模式-非终结符表达式-Nonterminal Expression角色：代表逻辑“非”操作的Not类，代表由一个布尔表达式通过逻辑“非”操作给出一个新的布尔表达式的操作
 */
public class Not extends Expression {

	private Expression exp;

	public Not(Expression exp) {
		super();
		this.exp = exp;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Not){
			Not not = (Not) obj;
            return exp.equals(not.exp);
        }
        return false;
	}

	@Override
	public String toString() {
		return "(Not " + exp.toString() + ")";
	}

	@Override
	public boolean interpret(Context context) {
		return !exp.interpret(context);
	}

}
