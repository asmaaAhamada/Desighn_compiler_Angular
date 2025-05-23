package SemanticCheck;

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
        Integer componentLine = table.getRows().stream()
                .filter(row -> row.getElementType().equals("decorator") &&
                        row.getElementName().equals("@Component"))
                .map(row -> row.getElementLine())
                .findFirst().orElse(null);

        if (componentLine == null) {
            System.err.println("[Error] No @Component found in the code");
            return false;
        }

        boolean hasSelector = table.getRows().stream()
                .anyMatch(row -> row.getElementType().equals("component-property") &&
                        row.getElementName().equals("selector") &&
                        row.getElementLine() > componentLine);

        if (!hasSelector) {
            System.err.println("[Error] Component is missing selector");
            return false;
        }

        return true;
    }



}
