package AST;

import java.util.ArrayList;
import java.util.List;

public class ImportModelDeclaration {
    private List<String> imports = new ArrayList<>();
    private String from;

    public List<String> getImports() {
        return imports;
    }
    public void setImports(List<String> imports) {
        this.imports = imports;
    }
    public void addImport(String imp) {
        this.imports.add(imp);
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ImportModelDeclaration{");
        sb.append("imports=[");
        for (int i = 0; i < imports.size(); i++) {
            sb.append(imports.get(i));
            if (i < imports.size() - 1) sb.append(", ");
        }
        sb.append("]");
        sb.append(", from='").append(from).append("'");
        sb.append("}");
        return sb.toString();
    }

}
