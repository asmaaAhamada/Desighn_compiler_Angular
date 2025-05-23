package AST;

public class EnumDeclaration {
    private EnumeratorList enumeratorList;

    public EnumeratorList getEnumeratorList() {
        return enumeratorList;
    }

    public void setEnumeratorList(EnumeratorList enumeratorList) {
        this.enumeratorList = enumeratorList;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("EnumDeclaration:\n");

        sb.append(indent).append("  EnumeratorList:\n");
        if (enumeratorList != null) {
            sb.append(enumeratorList.toString(indent + "    "));
        } else {
            sb.append(indent).append("    null\n");
        }

        return sb.toString();
    }
}
