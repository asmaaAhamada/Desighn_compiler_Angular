package AST;

import java.util.ArrayList;
import java.util.List;

public class CallFunctios {
    private String functionName;
    private final List<Expression> arguments = new ArrayList<>();

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void addArgument(Expression expr) {
        this.arguments.add(expr);
    }

    @Override
    public String toString() {
        return toString("");
    }
    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("CallFunctios:\n");
        sb.append(indent).append("  functionName: ").append(functionName).append("\n");
        sb.append(indent).append("  arguments:\n");
        for (Expression arg : arguments) {
            if (arg != null) {
                sb.append(arg.toString(indent + "    "));
            } else {
                sb.append(indent).append("    null\n");
            }
        }
        return sb.toString();
    }
}
