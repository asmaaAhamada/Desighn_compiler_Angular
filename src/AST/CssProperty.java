package AST;

public class CssProperty {
    private String name;
    private String value;

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

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        return indent + "CssProperty: " + (name != null ? name : "null") +
                " = " + (value != null ? value : "null") + "\n";
    }
}
