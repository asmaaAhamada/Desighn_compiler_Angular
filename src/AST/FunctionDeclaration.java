package AST;

public class FunctionDeclaration {
    private ParameterList parameterList;
    private Type type;
    private Block block;
    private Expression expression;

    public ParameterList getParameterList() {
        return parameterList;
    }
    public Type getType() {
        return type;
    }
    public Block getBlock() {
        return block;
    }
    public Expression getExpression() {
        return expression;
    }
    public void setParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setBlock(Block block) {
        this.block = block;
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
        sb.append(indent).append("FunctionDeclaration:\n");

        sb.append(indent).append("  Type: ");
        sb.append(type != null ? type.toString() : "null").append("\n");

        sb.append(indent).append("  ParameterList:\n");
        if (parameterList != null) {
            sb.append(parameterList);
        } else {
            sb.append(indent).append("    null\n");
        }
        sb.append(indent).append("  Block:\n");
        if (block != null) {
            sb.append(block.toString(indent + "    "));
        } else {
            sb.append(indent).append("    null\n");
        }

        sb.append(indent).append("  Expression:\n");
        if (expression != null) {
            sb.append(expression.toString(indent + "    "));
        } else {
            sb.append(indent).append("    null\n");
        }

        return sb.toString();
    }
}
