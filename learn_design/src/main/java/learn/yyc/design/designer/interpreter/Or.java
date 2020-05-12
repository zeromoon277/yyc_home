package learn.yyc.design.designer.interpreter;

/**
 * 解释器模式-非终结符表达式-Nonterminal Expression角色：代表逻辑“或”操作的Or类，代表由两个布尔表达式通过逻辑“或”操作给出一个新的布尔表达式的操作
 */
public class Or extends Expression {

	private Expression left;
	private Expression right;

	public Or(Expression left, Expression right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Or) {
			Or or = (Or) obj;
            return left.equals(or.left) && right.equals(or.right);
        }
        return false;
	}

	@Override
	public String toString() {
		return "(" + left.toString() + " OR " + right.toString() + ")";
	}

	@Override
	public boolean interpret(Context context) {
		return left.interpret(context) || right.interpret(context);
	}

}
