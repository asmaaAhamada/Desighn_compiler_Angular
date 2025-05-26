package SemanticCheck;

import SymbolTable.ImportTableRow;
import SymbolTable.TableStructure;

public class SemanticCheck {
    TableStructure symbolTable;

    public SemanticCheck(TableStructure symbolTable) {
        this.symbolTable = symbolTable;
    }

    public TableStructure getSymbolTable() {
        return symbolTable;
    }

    public boolean check() {

         if (!checkCurlyBrackets(this.symbolTable)) {
            System.out.println("Exception: Curly brackets missing in import!");
            return false;
        } else if (!checkSelector(this.symbolTable)) {
            System.out.println("Exception: Component is missing selector!");
            return false;

        } else {
            return true;
        }
    }

    public static boolean checkCurlyBrackets(TableStructure table) {
        boolean allImportsHaveCurly = table.getRows().stream()
                .filter(row -> row.getElementType().equals("import"))
                .allMatch(row -> row.getElementValue() != null && row.getElementValue().contains("{"));

        if (!allImportsHaveCurly) {
            System.err.println("[Error] One or more import statements are missing curly brackets '{ }'");
        }

        return allImportsHaveCurly;
    }


    private boolean checkSelector(TableStructure table) {

        ImportTableRow componentRow = table.getImportRows().stream()
                .filter(row -> "decorator".equals(row.getElementType()) &&
                        "@Component".equals(row.getElementValue()))
                .findFirst()
                .orElse(null);

        if (componentRow == null) {
            System.err.println("[Error] @Component is missing ");
            return false;
        }

        int componentLine = componentRow.getElementLine();


        boolean hasSelector = table.getRows().stream()
                .anyMatch(row -> "component-property".equals(row.getElementType()) &&
                        "selector".equals(row.getElementName()) &&
                        row.getElementLine() > componentLine);

        if (!hasSelector) {
            System.err.printf("[Error] Component is missing selector (after line %d)%n", componentLine);
            return false;
        }

        return true;
    }



}
