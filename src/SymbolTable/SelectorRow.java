package SymbolTable;

public class SelectorRow {
    private final String name;
    private final int line;
    private final int column;

    public SelectorRow(String name, int line, int column) {
        this.name = name;
        this.line = line;
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
