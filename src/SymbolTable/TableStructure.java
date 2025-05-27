package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class TableStructure {

    // الجداول المختلفة
    private List<TableRow> rows = new ArrayList<>();
    private List<ImportTableRow> importRows = new ArrayList<>();
    private List<TablerowComponent> componentRows = new ArrayList<>();

    // إضافة صف لجدول الرموز العادي
    public void addRow(String type, String name, int line, String value) {
        rows.add(new TableRow(type, name, line, value));
    }

    // إضافة صف لجدول import
    public void addImportRow(String type, String value, int line, String elementName, boolean isDeclared, boolean isUsed) {
        importRows.add(new ImportTableRow(type, value, line, elementName, isDeclared, isUsed));
    }

    // إضافة صف لجدول الـ components
    public void addComponentRow(String type, String name, int line) {
        // يتم حساب hasSymbol تلقائياً داخل الكونسـتراكتور
        componentRows.add(new TablerowComponent(type, name, line));
    }

    // getters
    public List<TableRow> getRows() {
        return rows;
    }

    public List<ImportTableRow> getImportRows() {
        return importRows;
    }

    public List<TablerowComponent> getComponentRows() {
        return componentRows;
    }

    // طباعة جدول الرموز
    public void printTable() {
        System.out.println("Symbol Table:");
        System.out.printf("+------------+-------------+-------+----------------+%n");
        System.out.printf("| Type       | Name        | Line  | Value          |%n");
        System.out.printf("+------------+-------------+-------+----------------+%n");

        for (TableRow row : rows) {
            System.out.printf("| %-10s | %-11s | %-5d | %-14s |%n",
                    row.getElementType(),
                    row.getElementName(),
                    row.getElementLine(),
                    row.getElementValue() != null ? row.getElementValue() : "N/A");
        }

        System.out.printf("+------------+-------------+-------+----------------+%n");
    }

    // طباعة جدول الـ import
    public void printImportTable() {
        System.out.println("Import Table:");
        System.out.printf("+------------+----------------+-------+------------+--------+%n");
        System.out.printf("| Type       | Value          | Line  | Declared   | Used   |%n");
        System.out.printf("+------------+----------------+-------+------------+--------+%n");

        for (ImportTableRow row : importRows) {
            System.out.printf("| %-10s | %-14s | %-5d | %-10s | %-6s |%n",
                    row.getElementType(),
                    row.getElementValue() != null ? row.getElementValue() : "N/A",
                    row.getElementLine(),
                    row.isDeclared() ? "Yes" : "No",
                    row.isUsed() ? "Yes" : "No");
        }

        System.out.printf("+------------+----------------+-------+------------+--------+%n");
    }

    // طباعة جدول الـ components
    public void printComponentTable() {
        System.out.println("Component Table:");
        System.out.printf("+------------+-------------+-------+------------+%n");
        System.out.printf("| Type       | Name        | Line  | HasSymbol  |%n");
        System.out.printf("+------------+-------------+-------+------------+%n");

        for (TablerowComponent row : componentRows) {
            System.out.printf("| %-10s | %-11s | %-5d | %-10s |%n",
                    row.getElementType(),
                    row.getElementName(),
                    row.getElementLine(),
                    row.hasSymbol() ? "true" : "false");
        }

        System.out.printf("+------------+-------------+-------+------------+%n");
    }
}
