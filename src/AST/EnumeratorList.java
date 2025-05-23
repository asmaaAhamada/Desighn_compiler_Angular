package AST;

import java.util.ArrayList;
import java.util.List;

public class EnumeratorList {
    private List<String> enumerators = new ArrayList<>();

    public List<String> getEnumerators() {
        return enumerators;
    }

    public void setEnumerators(List<String> enumerators) {
        this.enumerators = enumerators;
    }

    public void addEnumerator(String name) {
        this.enumerators.add(name);
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("EnumeratorList:\n");
        for (String enumName : enumerators) {
            sb.append(indent).append("  - ").append(enumName).append("\n");
        }
        if (enumerators.isEmpty()) {
            sb.append(indent).append("  (empty)\n");
        }
        return sb.toString();
    }
}
