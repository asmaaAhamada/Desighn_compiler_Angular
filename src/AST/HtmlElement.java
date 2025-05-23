package AST;
import java.util.ArrayList;
import java.util.List;

public class HtmlElement  {
    private String tagName;
    private final List<Attribute> attributes = new ArrayList<>();
    private final List<NgDirective> ngDirectives = new ArrayList<>();
    private final List<Object> children = new ArrayList<>();
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    public List<Attribute> getAttributes() {
        return attributes;
    }
    public List<NgDirective> getNgDirectives() {
        return ngDirectives;
    }
    public List<Object> getChildren() {
        return children;
    }
    @Override
    public String toString() {
        return toString("    ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("tagName='").append(tagName).append("'\n");
        if (!attributes.isEmpty()) {
            sb.append(indent).append("attributes=[\n");
            for (Attribute attr : attributes) {
                sb.append(indent).append(attr.toString().replaceAll("(?m)^", "    ")).append(",\n");
            }
            sb.append(indent).append("]\n");
        }
        if (!ngDirectives.isEmpty()) {
            sb.append(indent).append("ngDirectives=[\n");
            for (NgDirective dir : ngDirectives) {
                sb.append(indent).append(dir.toString().replaceAll("(?m)^", "    ")).append("\n");
            }
            sb.append(indent).append("]\n");
        }
        if (!children.isEmpty()) {
            sb.append(indent).append("children=[\n");
            for (Object child : children) {
                if (child != null) {
                    sb.append(indent).append(child.toString().replaceAll("(?m)^", "    ")).append("\n");
                }
            }
            sb.append(indent).append("]\n");
        }

        sb.append(indent).append("}");
        return sb.toString();
    }


}
