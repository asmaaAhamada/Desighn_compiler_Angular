package AST;

public class ClassDeclaration {
    private String className;
    private String extendsClassName; // قد تكون null
    private Block block;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getExtendsClassName() {
        return extendsClassName;
    }

    public void setExtendsClassName(String extendsClassName) {
        this.extendsClassName = extendsClassName;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return toString("    ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if(className != null){
            sb.append(indent).append("className: ").append(className).append("\n");
        }
        if(extendsClassName != null){
            sb.append(indent).append("extendsClassName: ").append(extendsClassName).append("\n");
        }
        if (block != null) {
            sb.append(indent).append("block:").append(block).append("\n");
        }
        return sb.toString();
    }
}
