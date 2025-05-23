package AST;

public class ThisStatement {
    private String variableName;
    private String assignedName;

    public String getVariableName() {
        return variableName;
    }
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getAssignedName() {
        return assignedName;
    }
    public void setAssignedName(String assignedName) {
        this.assignedName = assignedName;
    }

    @Override
    public String toString() {
        return "ThisStatement{" +
                "variableName='" + variableName + '\'' +
                ", assignedName='" + assignedName + '\'' +
                '}';
    }

}
