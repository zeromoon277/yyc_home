package learn.yyc.design.designer.interpreter;

/**
 * 解释器模式-非终结符表达式-Nonterminal Expression角色：代表逻辑“与”操作的And类，表示由两个布尔表达式通过逻辑“与”操作给出一个新的布尔表达式的操作
 */
public class And extends Expression {

	private Expression left;
	private Expression right;

	public And(Expression left, Expression right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof And) {
			And and = (And) obj;
            return left.equals(and.left) && right.equals(and.right);
        }
        return false;
	}

	@Override
	public String toString() {
		return "(" + left.toString() + " AND " + right.toString() + ")";
	}

	@Override
	public boolean interpret(Context context) {
		return left.interpret(context) && right.interpret(context);
	}

}
