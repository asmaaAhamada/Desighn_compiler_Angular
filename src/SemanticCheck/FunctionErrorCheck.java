package SemanticCheck;

import SymbolTable.TableStructure;
import SymbolTable.TableRowFunction;

public class FunctionErrorCheck {
    TableStructure symbolTable;

    public FunctionErrorCheck(TableStructure symbolTable) {
        this.symbolTable = symbolTable;
    }

    public TableStructure getSymbolTable() {
        return symbolTable;
    }

    public boolean check() {
        if (!checkFunctionCalls(symbolTable)) {
            System.out.println("Exception: One or more functions were called but not defined.");
            return false;
        } else {
            checkUnusedFunctions(symbolTable); // Just warnings, doesn't break check
            return true;
        }
    }

    private boolean checkFunctionCalls(TableStructure table) {
        boolean allCallsHaveDefinitions = true;

        for (TableRowFunction call : table.getFunctionRows()) {
            if ("function-call".equals(call.getType())) {
                boolean isDefined = table.getFunctionRows().stream()
                        .anyMatch(def -> "function".equals(def.getType())
                                && def.getName().equals(call.getName()));
                if (!isDefined) {
                    System.err.printf("[Error] Function '%s' is called at line %d but not defined!%n",
                            call.getName(), call.getLine());
                    allCallsHaveDefinitions = false;
                }
            }
        }

        return allCallsHaveDefinitions;
    }

    private void checkUnusedFunctions(TableStructure table) {
        for (TableRowFunction def : table.getFunctionRows()) {
            if ("function".equals(def.getType())) {
                boolean isUsed = table.getFunctionRows().stream()
                        .anyMatch(call -> "function-call".equals(call.getType())
                                && call.getName().equals(def.getName()));
                if (!isUsed) {
                    System.err.printf("[Warning] Function '%s' is defined at line %d but never used.%n",
                            def.getName(), def.getLine());
                }
            }
        }
    }
}
