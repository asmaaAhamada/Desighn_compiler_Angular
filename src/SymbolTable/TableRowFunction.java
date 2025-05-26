package SymbolTable;

public class TableRowFunction {
    String type;        // function or function-call
    String name;
    int line;

    public TableRowFunction(String type, String name, int line) {
        this.type = type;
        this.name = name;
        this.line = line;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }
}
