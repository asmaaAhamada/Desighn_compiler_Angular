package AST;

public class EnumValue {
    private String enumName;
    private String valueName;

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("EnumValue:\n");
        sb.append(indent).append("  EnumName: ").append(enumName != null ? enumName : "null").append("\n");
        sb.append(indent).append("  ValueName: ").append(valueName != null ? valueName : "null").append("\n");
        return sb.toString();
    }
}
