package AST;

public class Expression  {
    private CallFunctios callFunctios;
    private VariableDeclaration variableDeclaration;
    private String identifier;
    private String value;
    private Boolean booleanValue;

    public CallFunctios getCallFunctios() {
        return callFunctios;
    }
    public void setCallFunctios(CallFunctios callFunctios) {
        this.callFunctios = callFunctios;
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }
    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }
    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("Expression:\n");

        sb.append(indent).append("  CallFunctios:\n");
        if (callFunctios != null) {
            sb.append(callFunctios.toString(indent + "    "));
        } else {
            sb.append(indent).append("    null\n");
        }

        sb.append(indent).append("  VariableDeclaration:\n");
        if (variableDeclaration != null) {
            sb.append(variableDeclaration);
        } else {
            sb.append(indent).append("    null\n");
        }

        sb.append(indent).append("  Identifier: ").append(identifier != null ? identifier : "null").append("\n");
        sb.append(indent).append("  Value: ").append(value != null ? value : "null").append("\n");
        sb.append(indent).append("  BooleanValue: ").append(booleanValue != null ? booleanValue.toString() : "null").append("\n");

        return sb.toString();
    }
}
