package SymbolTable;

public class TableRowTag {
    private String tagName;
    private String type;       //مفتوح ولا مسكر
    private int line;
    private int column;        // رقم العمود
    private String status;

    public TableRowTag(String tagName, String type, int line, int column, String status) {
        this.tagName = tagName;
        this.type = type;
        this.line = line;
        this.column = column;
        this.status = status;
    }

    public String getTagName() {
        return tagName;
    }

    public String getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
