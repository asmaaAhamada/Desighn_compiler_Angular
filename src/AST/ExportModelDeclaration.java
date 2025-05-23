package AST;

public class ExportModelDeclaration {
    private String exportedType;
    private String exportedName;
    private Expression expression;
    private ClassDeclaration classDeclaration;

    public String getExportedType() {
        return exportedType;
    }

    public void setExportedType(String exportedType) {
        this.exportedType = exportedType;
    }

    public String getExportedName() {
        return exportedName;
    }

    public void setExportedName(String exportedName) {
        this.exportedName = exportedName;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public void setClassDeclaration(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    @Override
    public String toString() {
        return toString("    ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if(exportedType != null){
            sb.append(indent).append("ExportedType: ").append(exportedType).append("\n");
        }
        if(exportedName != null){
            sb.append(indent).append("ExportedName: ").append(exportedName).append("\n");
        }
        if (expression != null) {
            sb.append(indent).append("Expression:").append(expression).append("\n");
        }
        if (classDeclaration != null) {
            sb.append(indent).append("ClassDeclaration:\n").append(classDeclaration).append("\n");
        }

        return sb.toString();
    }
}
