package AST;

public class Statement  {
    private Declaration declaration;
    private HtmlProgram htmlProgram;
    private CssProgram cssProgram;
    private VariableDeclaration variableDeclaration;
    private ImportModelDeclaration importModelDeclaration;
    private ExportModelDeclaration exportModelDeclaration;
    private FunctionDeclaration functionDeclaration;
    private ClassDeclaration classDeclaration;
    private InterfaceDeclaration interfaceDeclaration;
    private ObjectCreation objectCreation;
    private EnumDeclaration enumDeclaration;
    private ConsolDeclaration consolDeclaration;
    private ExpressionStatement expressionStatement;
    private ReturnStatement returnStatement;
    private ThrowStatement throwStatement;
    private ObjectClass objectClass;
    private ObjectInterface objectInterface;
    private CallFunctios callFunctios;
    private Assignment assignment;
    private EmitStatement emitStatement;
    private ThisStatement thisStatement;

    public Declaration getDeclaration() {
        return declaration;
    }
    public HtmlProgram getHtmlProgram() {
        return htmlProgram;
    }
    public CssProgram getCssProgram() {
        return cssProgram;
    }
    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }
    public ImportModelDeclaration getImportModelDeclaration() {
        return importModelDeclaration;
    }
    public ExportModelDeclaration getExportModelDeclaration() {
        return exportModelDeclaration;
    }
    public FunctionDeclaration getFunctionDeclaration() {
        return functionDeclaration;
    }
    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }
    public InterfaceDeclaration getInterfaceDeclaration() {
        return interfaceDeclaration;
    }
    public ObjectCreation getObjectCreation() {
        return objectCreation;
    }
    public EnumDeclaration getEnumDeclaration() {
        return enumDeclaration;
    }
    public ConsolDeclaration getConsolDeclaration() {
        return consolDeclaration;
    }
    public ExpressionStatement getExpressionStatement() {
        return expressionStatement;
    }
    public ReturnStatement getReturnStatement() {
        return returnStatement;
    }
    public ThrowStatement getThrowStatement() {
        return throwStatement;
    }
    public ObjectClass getObjectClass() {
        return objectClass;
    }
    public ObjectInterface getObjectInterface() {
        return objectInterface;
    }
    public CallFunctios getCallFunctios() {
        return callFunctios;
    }
    public Assignment getAssignment() {
        return assignment;
    }
    public EmitStatement getEmitStatement() {
        return emitStatement;
    }
    public ThisStatement getThisStatement() {
        return thisStatement;
    }
    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }
    public void setHtmlProgram(HtmlProgram htmlProgram) {
        this.htmlProgram = htmlProgram;
    }
    public void setCssProgram(CssProgram cssProgram) {
        this.cssProgram = cssProgram;
    }
    public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }
    public void setImportModelDeclaration(ImportModelDeclaration importModelDeclaration) {
        this.importModelDeclaration = importModelDeclaration;
    }
    public void setExportModelDeclaration(ExportModelDeclaration exportModelDeclaration) {
        this.exportModelDeclaration = exportModelDeclaration;
    }
    public void setFunctionDeclaration(FunctionDeclaration functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }
    public void setClassDeclaration(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }
    public void setInterfaceDeclaration(InterfaceDeclaration interfaceDeclaration) {
        this.interfaceDeclaration = interfaceDeclaration;
    }
    public void setObjectCreation(ObjectCreation objectCreation) {
        this.objectCreation = objectCreation;
    }
    public void setEnumDeclaration(EnumDeclaration enumDeclaration) {
        this.enumDeclaration = enumDeclaration;
    }
    public void setConsolDeclaration(ConsolDeclaration consolDeclaration) {
        this.consolDeclaration = consolDeclaration;
    }
    public void setExpressionStatement(ExpressionStatement expressionStatement) {
        this.expressionStatement = expressionStatement;
    }
    public void setReturnStatement(ReturnStatement returnStatement) {
        this.returnStatement = returnStatement;
    }
    public void setThrowStatement(ThrowStatement throwStatement) {
        this.throwStatement = throwStatement;
    }
    public void setObjectClass(ObjectClass objectClass) {
        this.objectClass = objectClass;
    }
    public void setObjectInterface(ObjectInterface objectInterface) {
        this.objectInterface = objectInterface;
    }
    public void setCallFunctios(CallFunctios callFunctios) {
        this.callFunctios = callFunctios;
    }
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
    public void setEmitStatement(EmitStatement emitStatement) {
        this.emitStatement = emitStatement;
    }
    public void setThisStatement(ThisStatement thisStatement) {
        this.thisStatement = thisStatement;
    }
    @Override
    public String toString() {
        return toString("  ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder("Statement{\n");
        if (declaration != null) sb.append(indent).append("declaration=\n").append(declaration).append(", ");
        if (htmlProgram != null) sb.append(indent).append("htmlProgram=\n").append(htmlProgram).append(", ");
        if (cssProgram != null) sb.append(indent).append("cssProgram=\n").append(cssProgram).append(", ");
        if (variableDeclaration != null) sb.append(indent).append("variableDeclaration=\n").append(variableDeclaration).append(", ");
        if (importModelDeclaration != null) sb.append(indent).append("importModelDeclaration=\n").append(importModelDeclaration).append(", ");
        if (exportModelDeclaration != null) sb.append(indent).append("exportModelDeclaration=\n").append(exportModelDeclaration).append(", ");
        if (functionDeclaration != null) sb.append(indent).append("functionDeclaration=\n").append(functionDeclaration).append(", ");
        if (classDeclaration != null) sb.append(indent).append("classDeclaration=\n").append(classDeclaration).append(", ");
        if (interfaceDeclaration != null) sb.append(indent).append("interfaceDeclaration=\n").append(interfaceDeclaration).append(", ");
        if (objectCreation != null) sb.append(indent).append("objectCreation=\n").append(objectCreation).append(", ");
        if (enumDeclaration != null) sb.append(indent).append("enumDeclaration=\n").append(enumDeclaration).append(", ");
        if (consolDeclaration != null) sb.append(indent).append("consolDeclaration=\n").append(consolDeclaration).append(", ");
        if (expressionStatement != null) sb.append(indent).append("expressionStatement=\n").append(expressionStatement).append(", ");
        if (returnStatement != null) sb.append(indent).append("returnStatement=\n").append(returnStatement).append(", ");
        if (throwStatement != null) sb.append(indent).append("throwStatement=\n").append(throwStatement).append(", ");
        if (objectClass != null) sb.append(indent).append("objectClass=\n").append(objectClass).append(", ");
        if (objectInterface != null) sb.append(indent).append("objectInterface=\n").append(objectInterface).append(", ");
        if (callFunctios != null) sb.append(indent).append("callFunctios=\n").append(callFunctios).append(", ");
        if (assignment != null) sb.append(indent).append("assignment=\n").append(assignment).append(", ");
        if (emitStatement != null) sb.append(indent).append("emitStatement=\n").append(emitStatement).append(", ");
        if (thisStatement != null) sb.append(indent).append("thisStatement=\n").append(thisStatement).append(", ");
        if (sb.lastIndexOf(", ") == sb.length() - 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("\n }");
        return sb.toString();
    }

}