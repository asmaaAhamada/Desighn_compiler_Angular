package AST;

public class InterfaceDeclaration {
    private String identifier;
    private Block block;

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Block getBlock() {
        return block;
    }
    public void setBlock(Block block) {
        this.block = block;
    }
}
