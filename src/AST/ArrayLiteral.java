package AST;

import java.util.ArrayList;
import java.util.List;

public class ArrayLiteral {
    private List<String> values = new ArrayList<>();
    private List<String> stringContents = new ArrayList<>();
    private List<MapLiteral> mapLiterals = new ArrayList<>();

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getStringContents() {
        return stringContents;
    }

    public void setStringContents(List<String> stringContents) {
        this.stringContents = stringContents;
    }

    public List<MapLiteral> getMapLiterals() {
        return mapLiterals;
    }

    public void setMapLiterals(List<MapLiteral> mapLiterals) {
        this.mapLiterals = mapLiterals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(sb, "");
        return sb.toString();
    }
    private void toStringHelper(StringBuilder sb, String indent) {
        sb.append(indent).append("ArrayLiteral:\n");
        sb.append(indent).append("  values:\n");
        for (String value : values) {
            sb.append(indent).append("    ").append(value).append("\n");
        }
        sb.append(indent).append("  stringContents:\n");
        for (String content : stringContents) {
            sb.append(indent).append("    ").append(content).append("\n");
        }
        sb.append(indent).append("  mapLiterals:\n");
        for (MapLiteral map : mapLiterals) {
            if (map != null) {
                sb.append(map);
            } else {
                sb.append(indent).append("    null\n");
            }
        }
    }
}
