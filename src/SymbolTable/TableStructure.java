package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class TableStructure {
    List<TableRow> rows = new ArrayList<>();
    List<ImportTableRow> importRows = new ArrayList<>();
    List<TableRowFunction> functionRows = new ArrayList<>();
    public void addRow(String type, String name, int line, String value) {
        TableRow row = new TableRow(type, name, line, value);
        rows.add(row);
    }

    public void addImportRow(String type, String value, int line,String elementname, boolean isDeclared, boolean isUsed) {
        ImportTableRow row = new ImportTableRow(type, value, line,elementname, isDeclared, isUsed);
        importRows.add(row);
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
}
