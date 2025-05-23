package AST;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private List<Statement> statementArrayList = new ArrayList<>();

    public List<Statement> getStatementArrayList() {
        return statementArrayList;
    }
    public void setStatementArrayList(List<Statement> statementArrayList) {
        this.statementArrayList = statementArrayList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Program{\n");
        for (Statement stmt : statementArrayList) {
            sb.append(stmt.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
