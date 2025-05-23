package AST;

public class Attribute {
    private String name;
    private String value;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return toString("    ");
    }
    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("name: ").append(name).append("\n");
        sb.append(indent).append("value: ").append(value).append("\n");
        sb.append(indent).append("type: ").append(type).append("\n");
        return sb.toString();
    }
}
