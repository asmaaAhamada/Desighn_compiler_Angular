package AST;

import java.util.ArrayList;
import java.util.List;

public class ObjectLiteral {
    private List<ObjectProperty> objectProperties = new ArrayList<>();

    public List<ObjectProperty> getObjectProperties() {
        return objectProperties;
    }
    public void setObjectProperties(List<ObjectProperty> objectProperties) {
        this.objectProperties = objectProperties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectLiteral {\n");
        for (ObjectProperty prop : objectProperties) {
            sb.append("  ").append(prop).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
