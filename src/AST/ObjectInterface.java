package AST;

public class ObjectInterface {
    private String name;
    private String typeName;
    private ObjectInterfaceBody objectInterfaceBody;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public ObjectInterfaceBody getObjectInterfaceBody() {
        return objectInterfaceBody;
    }
    public void setObjectInterfaceBody(ObjectInterfaceBody objectInterfaceBody) {
        this.objectInterfaceBody = objectInterfaceBody;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("ObjectInterface:\n");
        sb.append(indent).append("  Name: ").append(name != null ? name : "null").append("\n");
        sb.append(indent).append("  TypeName: ").append(typeName != null ? typeName : "null").append("\n");
        sb.append(indent).append("  ObjectInterfaceBody:\n");
        if (objectInterfaceBody != null) {
            sb.append(objectInterfaceBody.toString(indent + "    "));
        } else {
            sb.append(indent).append("    null\n");
        }
        return sb.toString();
    }
}
