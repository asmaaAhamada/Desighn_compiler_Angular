package SemanticCheck;

import SymbolTable.TableRowTag;
import SymbolTable.TableStructure;

import java.util.List;
import java.util.Stack;

public class CheckTag {
    private final TableStructure symbolTable;

    public CheckTag(TableStructure symbolTable) {
        this.symbolTable = symbolTable;
    }

    public TableStructure getSymbolTable() {
        return symbolTable;
    }

    public boolean check() {
        boolean allMatched = true;

        Stack<TableRowTag> openTags = new Stack<>();
        List<TableRowTag> tags = symbolTable.getTagRows();

        for (TableRowTag tag : tags) {
            if ("self-closing".equalsIgnoreCase(tag.getType())) {
                // تجاهل التاجات التي تغلق  سيلف
                tag.setStatus("closed");
                continue;
            }

            if ("open".equalsIgnoreCase(tag.getType())) {
                openTags.push(tag);
            } else if ("close".equalsIgnoreCase(tag.getType())) {
                if (!openTags.isEmpty()) {
                    TableRowTag lastOpen = openTags.peek();
                    if (lastOpen.getTagName().equals(tag.getTagName())) {
                        // تطابق  بين الفتح والإغلاق
                        lastOpen.setStatus("matched");
                        tag.setStatus("matched");
                        openTags.pop();
                    } else {
                        // عدم تطابق بين التاج المفتوح والمغلق
                        tag.setStatus("error: mismatched");
                        lastOpen.setStatus("error: mismatched");
                        System.err.printf("[Error] Tag mismatch: <%s> opened at line %d doesn't match </%s> at line %d.%n",
                                lastOpen.getTagName(), lastOpen.getLine(),
                                tag.getTagName(), tag.getLine());
                        openTags.pop(); //
                        allMatched = false;
                    }
                } else {
                    tag.setStatus("error: no matching open tag");
                    System.err.printf("[Error] Closing tag </%s> at line %d has no matching opening tag.%n",
                            tag.getTagName(), tag.getLine());
                    allMatched = false;
                }
            }
        }

        // أي تاج مفتوح متبقي يعتبر بدون إغلاق
        while (!openTags.isEmpty()) {
            TableRowTag unclosed = openTags.pop();
            unclosed.setStatus("error: no closing tag");
            System.err.printf("[Error] Opening tag <%s> at line %d has no matching closing tag.%n",
                    unclosed.getTagName(), unclosed.getLine());
            allMatched = false;
        }

        return allMatched;
    }

}
