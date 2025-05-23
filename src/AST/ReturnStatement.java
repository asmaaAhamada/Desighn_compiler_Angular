package AST;

public class ReturnStatement {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "ReturnStatement{" +
                "expression=" + expression +
                '}';
    }
}
