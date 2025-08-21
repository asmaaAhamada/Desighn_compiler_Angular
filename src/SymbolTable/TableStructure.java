package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class TableStructure {
    List<TableRow> rows = new ArrayList<>();
    List<ImportTableRow> importRows = new ArrayList<>();
    List<TableRowFunction> functionRows = new ArrayList<>();
    List<TableRowTag> tagRows = new ArrayList<>();
    List<SelectorRow> selectorRows = new ArrayList<>();
    public void addRow(String type, String name, int line, String value) {
        TableRow row = new TableRow(type, name, line, value);
        rows.add(row);
    }

    public void addImportRow(String type, String value, int line,String elementname, boolean isDeclared, boolean isUsed) {
        ImportTableRow row = new ImportTableRow(type, value, line,elementname, isDeclared, isUsed);
        importRows.add(row);
    }
    public void addTagRow(String tagName, String type, int line, int column, String status) {
        tagRows.add(new TableRowTag(tagName, type, line, column, status));
    }

    public void addSelector(String name, int line, int column) {
        selectorRows.add(new SelectorRow(name, line, column));
    }
    public List<TableRow> getRows() {
        return rows;
    }



    public List<ImportTableRow> getImportRows() {
        return importRows;
    }
    public void addFunctionRow(String type, String name, int line) {
        functionRows.add(new TableRowFunction(type, name, line));
    }

    public List<TableRowFunction> getFunctionRows() {
        return functionRows;
    }

    public List<TableRowTag> getTagRows() {
        return tagRows;
    }
    public List<SelectorRow> getSelectorRows() {
        return selectorRows;
    }
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
    public void printFunctionTable() {
        System.out.println("Function Table:");
        System.out.printf("+--------------+----------------+-------+%n");
        System.out.printf("| Type         | Name           | Line  |%n");
        System.out.printf("+--------------+----------------+-------+%n");

        for (TableRowFunction row : functionRows) {
            System.out.printf("| %-12s | %-14s | %-5d |%n",
                    row.getType(), row.getName(), row.getLine());
        }

        System.out.printf("+--------------+----------------+-------+%n");
    }

    public void printTagTable() {
        System.out.println("Tag Table:");
        System.out.printf("+------------+--------+------+--------+----------------------+%n");
        System.out.printf("| Tag Name   | Type   | Line | Column | Status               |%n");
        System.out.printf("+------------+--------+------+--------+----------------------+%n");

        for (TableRowTag row : tagRows) {
            System.out.printf("| %-10s | %-6s | %-4d | %-6d | %-20s |%n",
                    row.getTagName(),
                    row.getType(),
                    row.getLine(),
                    row.getColumn(),
                    row.getStatus());
        }

        System.out.printf("+------------+--------+------+--------+----------------------+%n");
    }
    public void printSelectorTable() {
        System.out.println("Selector Table:");
        System.out.printf("+----------------------+--------+--------+%n");
        System.out.printf("| Selector Name        | Line   | Column |%n");
        System.out.printf("+----------------------+--------+--------+%n");

        for (SelectorRow row : selectorRows) {
            System.out.printf("| %-20s | %-6d | %-6d |%n",
                    row.getName(), row.getLine(), row.getColumn());
        }

        System.out.printf("+----------------------+--------+--------+%n");
    }
}
