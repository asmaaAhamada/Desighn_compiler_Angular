package SemanticCheck;

import SymbolTable.TableStructure;

public class CheckImport {
    TableStructure symbolTable;
    public CheckImport( TableStructure symbolTable){
        this.symbolTable = symbolTable;
    }
    public TableStructure getSymbolTable() {
        return symbolTable;
    }
    public  boolean check() {
        if (!checkCommonModule( this.symbolTable)) {
            System.out.println("Exception: Missing CommonModule import!");
            return false;
        } else if (!checkComponent(this.symbolTable)) {
            System.out.println("Exception: component used without declaration!");
            return false;
        }
        return true;
    }

    public static boolean checkCommonModule(TableStructure table) {
        boolean found = table.getImportRows().stream()
                .filter(row -> row.getElementType().equals("import"))
                .anyMatch(row -> {
                    String value = row.getElementValue();
                    return value != null && value.contains("CommonModule");
                });

        if (!found) {
            System.err.println("[Error] Missing import: CommonModule");
        }

        return found;
    }

    public static boolean checkComponent(TableStructure table) {
        boolean isComponentUsed = table.getRows().stream()
                .anyMatch(row -> row.getElementType().equals("decorator") &&
                        row.getElementName().equals("@Component"));

        boolean isComponentImported = table.getImportRows().stream()
                .anyMatch(row -> row.getElementValue() != null && row.getElementValue().contains("Component"));

        if (isComponentUsed && !isComponentImported) {
            table.getRows().stream()
                    .filter(row -> row.getElementType().equals("decorator") &&
                            row.getElementName().equals("@Component"))
                    .forEach(row -> System.err.printf("[Error] '@Component' used at line %d without importing 'Component'%n", row.getElementLine()));
            return false;
        }

        return true;
    }
}
