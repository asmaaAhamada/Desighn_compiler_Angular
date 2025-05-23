package AST;

import java.util.ArrayList;
import java.util.List;

public class ObjectCreation {
    private String variableName;
    private String className;
    private List<Expression> arguments = new ArrayList<>();

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

    public List<Expression> getArguments() {
        return arguments;
    }
    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("ObjectCreation:\n");
        sb.append(indent).append("  VariableName: ")
                .append(variableName != null ? variableName : "null").append("\n");
        sb.append(indent).append("  ClassName: ")
                .append(className != null ? className : "null").append("\n");

        sb.append(indent).append("  Arguments:\n");
        if (arguments != null) {
            for (Expression expr : arguments) {
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
