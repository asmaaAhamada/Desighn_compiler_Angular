package SemanticCheck;
import SymbolTable.TableStructure;
import SymbolTable.SelectorRow;

import java.util.HashSet;
import java.util.Set;


public class CheckUniqueSelector {

    TableStructure symbolTable;

    public CheckUniqueSelector(TableStructure symbolTable) {
        this.symbolTable = symbolTable;
    }

    public TableStructure getSelectorTable() {
        return symbolTable;
    }


    public boolean check() {
        if (!checkNoDuplicateSelectors(symbolTable)) {
            System.out.println("Exception: Duplicate selectors found!");
            return false;
        }
        return true;
    }



    public static boolean checkNoDuplicateSelectors(TableStructure table) {
        Set<String> seen = new HashSet<>();
        boolean isValid = true;

        for (SelectorRow row : table.getSelectorRows()) {
            String selectorName = row.getName().toLowerCase();

            if (seen.contains(selectorName)) {
                System.err.printf("[Error] Duplicate selector '%s' found at line %d, column %d%n",
                        row.getName(), row.getLine(), row.getColumn());
                isValid = false;
            } else {
                seen.add(selectorName);
            }
        }

        return isValid;
    }






}