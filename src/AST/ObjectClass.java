package AST;

import java.util.List;

public class ObjectClass {
    private String variableName;
    private String className;
    private List<Expression> expressions;

    public String getVariableName() {
        return variableName;
    }
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }
    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("ObjectClass:\n");
        sb.append(indent).append("  VariableName: ")
                .append(variableName != null ? variableName : "null").append("\n");
        sb.append(indent).append("  ClassName: ")
                .append(className != null ? className : "null").append("\n");
        sb.append(indent).append("  Expressions:\n");
        if (expressions != null) {
            for (Expression expr : expressions) {
                if (expr != null) {
                    sb.append(expr.toString(indent + "    "));
                } else {
                    sb.append(indent).append("    null\n");
                }
            }
        } else {
            sb.append(indent).append("    null\n");
        }
        return sb.toString();
    }
}
