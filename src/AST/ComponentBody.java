package AST;

import java.util.ArrayList;
import java.util.List;

public class ComponentBody {
    private String selector;
    private boolean standalone;
    private HtmlProgram htmlProgram;
    private ArrayLiteral arrayLiteral;
    private CssProgram cssProgram;

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public boolean isStandalone() {
        return standalone;
    }
    public void setStandalone(boolean standalone) {
        this.standalone = standalone;
    }

    public HtmlProgram getHtmlProgram() {
        return htmlProgram;
    }
    public void setHtmlProgram(HtmlProgram htmlProgram) {
        this.htmlProgram = htmlProgram;
    }

    public ArrayLiteral getArrayLiteral() {
        return arrayLiteral;
    }
    public void setArrayLiteral(ArrayLiteral arrayLiteral) {
        this.arrayLiteral = arrayLiteral;
    }

    public CssProgram getCssProgram() {
        return cssProgram;
    }
    public void setCssProgram(CssProgram cssProgram) {
        this.cssProgram = cssProgram;
    }

    @Override
    public String toString() {
        return toString("    ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if (selector != null) {
            sb.append(indent).append("selector: ").append(selector).append("\n");
        }
        if (selector != null) {
            sb.append(indent).append("standalone: ").append(standalone).append("\n");
        }
        if (htmlProgram != null) {
            sb.append(indent).append("htmlProgram: ").append(htmlProgram).append("\n");
        }
        if (arrayLiteral != null) {
            sb.append(indent).append("arrayLiteral: ").append(arrayLiteral).append("\n");
        }
        if (cssProgram != null) {
            sb.append(indent).append("cssProgram: ").append(cssProgram).append("\n");
        }
        return sb.toString();
    }
}

