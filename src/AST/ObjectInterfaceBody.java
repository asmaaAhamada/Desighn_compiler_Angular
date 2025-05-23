package AST;

import java.util.ArrayList;
import java.util.List;

public class ObjectInterfaceBody {
    public static class Property {
        private final String key;
        private final String value;

        public Property(String key, String value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }

    private final List<Property> properties = new ArrayList<>();

    public List<Property> getProperties() {
        return properties;
    }
    public void addProperty(Property property) {
        properties.add(property);
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if (properties.isEmpty()) {
            sb.append(indent).append("No properties\n");
        } else {
            for (Property prop : properties) {
                sb.append(indent).append("- ").append(prop.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return toString("");
    }
}
