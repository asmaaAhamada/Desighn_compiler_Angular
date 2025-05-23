package AST;

public class Decorator {
    private Type type;
    private String decoratorName;
    private String targetName;
    private String className;

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public String getDecoratorName() {
        return decoratorName;
    }
    public void setDecoratorName(String decoratorName) {
        this.decoratorName = decoratorName;
    }

    public String getTargetName() {
        return targetName;
    }
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if (type != null) {
            sb.append(indent).append("Type: ").append(type).append("\n");
        }
        if (type != null) {
            sb.append(indent).append("DecoratorName: ").append(decoratorName).append("\n");
        }
        if (type != null) {
            sb.append(indent).append("TargetName: ").append(targetName).append("\n");
        }
        if (type != null) {
            sb.append(indent).append("ClassName: ").append(className).append("\n");
        }
        return sb.toString();
    }
}
