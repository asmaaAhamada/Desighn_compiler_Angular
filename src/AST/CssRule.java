package AST;

import java.util.ArrayList;
import java.util.List;

public class CssRule {
    private Selector selector;
    private List<CssProperty> cssProperty = new ArrayList<>();
    private CallFunctios callFunctios;

    public Selector getSelector() {
        return selector;
    }


    public List<CssProperty> getCssProperty() {
        return cssProperty;
    }

    public CallFunctios getCallFunctios() {
        return callFunctios;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public void setCssProperty(List<CssProperty> cssProperty) {
        this.cssProperty = cssProperty;
    }

    public void addCssProperty(CssProperty property) {
        this.cssProperty.add(property);
    }

    public void setCallFunctios(CallFunctios callFunctios) {
        this.callFunctios = callFunctios;
    }


    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if (selector != null) {
            sb.append(indent).append("Selector: ").append(selector).append("\n");
        }
        if (cssProperty != null && !cssProperty.isEmpty()) {
            sb.append(indent).append("CssProperties:\n");
            for (CssProperty prop : cssProperty) {
                sb.append(prop.toString(indent + "    "));
            }
        }
        if (callFunctios != null) {
            sb.append(indent).append("CallFunctios:\n").append(callFunctios.toString(indent + "    ")).append("\n");
        }
        return sb.toString();
    }
}
