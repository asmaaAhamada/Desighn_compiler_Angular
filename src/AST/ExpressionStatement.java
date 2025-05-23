package AST;

public class ExpressionStatement {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("ExpressionStatement:\n");
        if (expression != null) {
            sb.append(expression.toString(indent + "  "));
        } else {
            sb.append(indent).append("  null\n");
        }
        return sb.toString();
    }
}
