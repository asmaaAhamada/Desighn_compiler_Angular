package SymbolTable;

public class ImportTableRow {
    String elementType;
    String elementValue;
    Integer elementLine;
    String elementname;
    boolean isDeclared;
    boolean isUsed;

    public ImportTableRow(String elementType, String elementValue, Integer elementLine,String elementname, boolean isDeclared, boolean isUsed) {
        this.elementType = elementType;
        this.elementValue = elementValue;
        this.elementLine = elementLine;
        this.elementname = elementname;
        this.isDeclared = isDeclared;
        this.isUsed = isUsed;

    }

    public String getElementType() {
        return elementType;
    }

    public String getElementValue() {
        return elementValue;
    }

    public Integer getElementLine() {
        return elementLine;
    }

    public boolean isDeclared() {
        return isDeclared;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setDeclared(boolean declared) {
        isDeclared = declared;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
