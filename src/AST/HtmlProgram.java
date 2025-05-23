package AST;

public class HtmlProgram  {
    private HtmlElement htmlElement;

    public HtmlElement getHtmlElement() {
        return htmlElement;
    }
    public void setHtmlElement(HtmlElement htmlElement) {
        this.htmlElement = htmlElement;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if (htmlElement != null) {
            sb.append(indent).append("htmlElement:").append(htmlElement).append("\n");
        }
        return sb.toString();
    }

}