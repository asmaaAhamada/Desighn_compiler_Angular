package SemanticCheck;

import SymbolTable.TablerowComponent;
import SymbolTable.TableStructure;

public class ComponentCheck {

    TableStructure symbolTable;

    public ComponentCheck(TableStructure symbolTable) {
        this.symbolTable = symbolTable;
    }

    public TableStructure getSymbolTable() {
        return symbolTable;
    }

    public boolean check() {
        return checkBeforeComponent(this.symbolTable);
    }

    private boolean checkBeforeComponent(TableStructure table) {
        boolean hasAtComponent = table.getComponentRows().stream()
                .anyMatch(row -> row.getElementType().equals("decorator")
                        && row.hasSymbol()); // فقط لو فيه @

        if (!hasAtComponent) {
            System.err.println("Exception: No '@' found before any Component!");
            return false;
        }

        // إذا وجدنا @Component، نبلغ عن الأخطاء في باقي العناصر
        table.getComponentRows().stream()
                .filter(row -> row.getElementType().equals("decorator"))
                .filter(row -> row.getElementName().contains("Component") && !row.hasSymbol())
                .forEach(row -> System.err.printf("[Error] Missing '@' before 'Component' at line %d%n", row.getElementLine()));

        return true;
    }

}