package AST;

import java.util.List;

public class HtmlContent {
    private List<String> interpolations;
    private String textContent;
    private String identifier;
    private boolean hasColonAfterIdentifier;

    public void setInterpolations(List<String> interpolations) {
        this.interpolations = interpolations;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setHasColonAfterIdentifier(boolean hasColonAfterIdentifier) {
        this.hasColonAfterIdentifier = hasColonAfterIdentifier;
    }

    @Override
    public String toString() {
        return toString("    ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("HtmlContent:\n");
        if (interpolations != null && !interpolations.isEmpty()) {
            sb.append(indent).append("Interpolations:\n");
            for (String interp : interpolations) {
                sb.append(indent).append("- ").append(interp).append("\n");
            }
        }
        if(textContent != null){
            sb.append(indent).append("TextContent: ").append(textContent).append("\n");
        }
        if(identifier != null){
            sb.append(indent).append("Content: ").append(identifier).append("\n");
        }
        if(textContent != null){
            sb.append(indent).append("HasColonAfterIdentifier: ").append(hasColonAfterIdentifier).append("\n");
        }
        return sb.toString();
    }
}
