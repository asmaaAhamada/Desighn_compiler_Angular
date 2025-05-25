package SymbolTable;

public class TablerowComponent {
    String Type;
    String Name;
    Integer Line;
    boolean hasSymbol; // العمود الجديد

    public TablerowComponent(String Type, String Name, Integer Line) {
        this.Type = Type;
        this.Name = Name;
        this.Line = Line;
        this.hasSymbol = Name.startsWith("@") && Name.contains("Component"); // تحديد القيمة
    }

    public String getElementType() {
        return Type;
    }

    public String getElementName() {
        return Name;
    }

    public Integer getElementLine() {
        return Line;
    }

    public boolean hasSymbol() {
        return hasSymbol;
    }

    public void setHasSymbol(boolean hasSymbol) {
        this.hasSymbol = hasSymbol;
    }
}