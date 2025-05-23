package AST;

import java.util.ArrayList;
import java.util.List;

public class ComponentDeclaration {
    private List<ComponentBody> componentBodyArrayList = new ArrayList<>();

    public List<ComponentBody> getComponentBodyArrayList() {
        return componentBodyArrayList;
    }

    public void setComponentBodyArrayList(List<ComponentBody> componentBodyArrayList) {
        this.componentBodyArrayList = componentBodyArrayList;
    }

    @Override
    public String toString() {
        return toString("    ");
    }
    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("ComponentBody:{\n");
        for (ComponentBody body : componentBodyArrayList) {
            if (body != null) {
                sb.append(body.toString(indent + "    "));
            }
        }
        sb.append(indent).append("}\n");
        return sb.toString();
    }
}
