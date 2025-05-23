package AST;

import java.util.ArrayList;
import java.util.List;

public class ConsolDeclaration {
    private final List<Expression> expressions = new ArrayList<>();

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void addExpression(Expression expression) {
        this.expressions.add(expression);
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("ConsolDeclaration:\n");
        for (Expression expr : expressions) {
            if (expr != null) {
                sb.append(expr.toString(indent + "  "));
            } else {
                sb.append(indent).append("  null\n");
            }
        }
        return sb.toString();
    }
}
