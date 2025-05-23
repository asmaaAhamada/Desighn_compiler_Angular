package AST;

public class EmitStatement {
    private ObjectLiteral objectLiteral;

    public ObjectLiteral getObjectLiteral() {
        return objectLiteral;
    }

    public void setObjectLiteral(ObjectLiteral objectLiteral) {
        this.objectLiteral = objectLiteral;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("EmitStatement:\n");

        sb.append(indent).append("  ObjectLiteral:\n");
        if (objectLiteral != null) {
            sb.append(objectLiteral);
        } else {
            sb.append(indent).append("    null\n");
        }

        return sb.toString();
    }
}
