package AST;

import java.util.ArrayList;
import java.util.List;

public class TypeAssertion {
    private Type type;

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "TypeAssertion{" +
                "type=" + (type != null ? type.toString() : "null") +
                '}';
    }

}