package SymbolTable;

public class TableRow {
    String elementType;
    String elementName;
    String elementValue;
    Integer elementLine;

    public TableRow(String elementType, String elementName, Integer elementLine, String elementValue) {
        this.elementType = elementType;
        this.elementName = elementName;
        this.elementLine = elementLine;
        this.elementValue = elementValue;
    }

    public String getElementType() {
        return elementType;
    }

    public String getElementName() {
        return elementName;
    }

    public Integer getElementLine() {
        return elementLine;
    }

    public String getElementValue() {
        return elementValue;
    }
}
