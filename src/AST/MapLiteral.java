package AST;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapLiteral {
    private Map<String, Object> properties = new LinkedHashMap<>();

    public Map<String, Object> getProperties() {
        return properties;
    }
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MapLiteral:\n");
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ");
            Object value = entry.getValue();
            if (value == null) {
                sb.append("null");
            } else {
                sb.append(value);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
