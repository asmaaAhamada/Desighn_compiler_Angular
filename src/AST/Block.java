package AST;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private List<Statement> statementArrayList = new ArrayList<>();
    public List<Statement> getStatementArrayList() {
        return statementArrayList;
    }
    public void setStatementArrayList(List<Statement> statementArrayList) {
        this.statementArrayList = statementArrayList;
    }

    @Override
    public String toString() {
        return toString("    ");
    }
    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        for (Statement stmt : statementArrayList) {
            if (stmt != null) {
                sb.append(indent).append("statementArrayList:\n").append(stmt).append("\n");
            }
        }
        return sb.toString();
    }
}
