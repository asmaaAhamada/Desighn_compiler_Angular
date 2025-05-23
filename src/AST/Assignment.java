package AST;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private String target;
    private Expression expression;
    private List<Any_type> any_typeArrayList = new ArrayList<>();

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public List<Any_type> getAny_typeArrayList() {
        return any_typeArrayList;
    }

    public void setAny_typeArrayList(List<Any_type> any_typeArrayList) {
        this.any_typeArrayList = any_typeArrayList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(sb, "");
        return sb.toString();
    }
    private void toStringHelper(StringBuilder sb, String indent) {
        sb.append(indent).append("Assignment:\n");
        sb.append(indent).append("  target: ").append(target).append("\n");
        sb.append(indent).append("  expression:\n");
        if (expression != null) {
            sb.append(expression.toString(indent + "    "));
        } else {
            sb.append(indent).append("    null\n");
        }
        sb.append(indent).append("  any_typeArrayList:\n");
        for (Any_type any : any_typeArrayList) {
            if (any != null) {
                sb.append(any);
            } else {
                sb.append(indent).append("    null\n");
            }
        }
    }
}
