package AST;

import java.util.ArrayList;
import java.util.List;

public class CssProgram {
    private List<CssRule> cssRuleArrayList = new ArrayList<>();

    public List<CssRule> getCssRuleArrayList() {
        return cssRuleArrayList;
    }

    public void setCssRuleArrayList(List<CssRule> cssRuleArrayList) {
        this.cssRuleArrayList = cssRuleArrayList;
    }

    @Override
    public String toString() {
        return toString("    ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        for (CssRule rule : cssRuleArrayList) {
            if (rule != null) {
                sb.append(indent).append("CssRule:\n");
                sb.append(rule.toString(indent + "  "));
            }
        }
        return sb.toString();
    }
}
