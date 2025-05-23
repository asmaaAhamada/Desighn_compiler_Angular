package AST;

public class NgDirective {
    private String directiveName;
    private String directiveValue;

    public String getDirectiveName() {
        return directiveName;
    }
    public void setDirectiveName(String directiveName) {
        this.directiveName = directiveName;
    }
    public String getDirectiveValue() {
        return directiveValue;
    }
    public void setDirectiveValue(String directiveValue) {
        this.directiveValue = directiveValue;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("  DirectiveName: ")
                .append(directiveName != null ? directiveName : "null").append("\n");
        sb.append(indent).append("  DirectiveValue: ")
                .append(directiveValue != null ? directiveValue : "null").append("\n");
        return sb.toString();
    }
}
