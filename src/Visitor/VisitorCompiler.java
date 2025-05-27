package Visitor;

import AST.*;
import SymbolTable.TableStructure;
import antlr.HTMLParser;
import antlr.HTMLParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import SemanticCheck.SemanticCheck;
import SemanticCheck.CheckImport;
import SemanticCheck.ComponentCheck;
public class VisitorCompiler extends HTMLParserBaseVisitor {
    TableStructure symbolTable = new TableStructure();

    public VisitorCompiler() {
    }

    @Override
    public Object visitProgram(HTMLParser.ProgramContext ctx) {
        Program programNode = new Program();
        List<Statement> statements = new ArrayList<>();
        for (HTMLParser.StatementContext stmtCtx : ctx.statement()) {
            Statement stmt = (Statement) visit(stmtCtx);
            statements.add(stmt);
        }
        programNode.setStatementArrayList(statements);
        // Print the symbol table at the end of parsing
        System.out.println("\n================== Symbol Table ==================");
        symbolTable.printTable();
        SemanticCheck semanticCheck = new SemanticCheck(symbolTable);
        boolean passed = semanticCheck.check();
        System.out.println("\nSemantic check status: " + (passed ? "Passed ✅" : "Failed ❌"));

        System.out.println("\n================== Symbol Table2 ==================");
        symbolTable.printImportTable();
        CheckImport importc=new CheckImport(symbolTable);

        boolean passed1 = importc.check();
        System.out.println("\nSemantic check status: " + (passed1 ? "Passed ✅" : "Failed ❌"));

        System.out.println("\n================== Symbol Table3 ==================");
        symbolTable.printComponentTable();


        ComponentCheck component = new ComponentCheck(symbolTable);


        boolean passed2 = component.check();

        System.out.println("\nSemantic check status: " + (passed2 ? "Passed ✅" : "Failed ❌"));

        return programNode;
    }

    @Override
    public Object visitStatement(HTMLParser.StatementContext ctx) {
        Statement statementNode = new Statement();
        if (ctx.declaration() != null) {
            Declaration decl = (Declaration) visit(ctx.declaration());
            statementNode.setDeclaration(decl);
        } else if (ctx.htmlProgram() != null) {
            HtmlProgram html = (HtmlProgram) visit(ctx.htmlProgram());
            statementNode.setHtmlProgram(html);
        } else if (ctx.cssProgram() != null) {
            CssProgram css = (CssProgram) visit(ctx.cssProgram());
            statementNode.setCssProgram(css);
        } else if (ctx.variableDeclaration() != null) {
            VariableDeclaration varDecl = (VariableDeclaration) visit(ctx.variableDeclaration());
            statementNode.setVariableDeclaration(varDecl);
        } else if (ctx.importModelDeclaration() != null) {
            ImportModelDeclaration imp = (ImportModelDeclaration) visit(ctx.importModelDeclaration());
            statementNode.setImportModelDeclaration(imp);
        } else if (ctx.exportModelDeclaration() != null) {
            ExportModelDeclaration exp = (ExportModelDeclaration) visit(ctx.exportModelDeclaration());
            statementNode.setExportModelDeclaration(exp);
        } else if (ctx.functionDeclaration() != null) {
            FunctionDeclaration func = (FunctionDeclaration) visit(ctx.functionDeclaration());
            statementNode.setFunctionDeclaration(func);
        } else if (ctx.classDeclaration() != null) {
            ClassDeclaration cls = (ClassDeclaration) visit(ctx.classDeclaration());
            statementNode.setClassDeclaration(cls);
        } else if (ctx.interfaceDeclaration() != null) {
            InterfaceDeclaration interf = (InterfaceDeclaration) visit(ctx.interfaceDeclaration());
            statementNode.setInterfaceDeclaration(interf);
        } else if (ctx.objectCreation() != null) {
            ObjectCreation obj = (ObjectCreation) visit(ctx.objectCreation());
            statementNode.setObjectCreation(obj);
        } else if (ctx.enumDeclaration() != null) {
            EnumDeclaration en = (EnumDeclaration) visit(ctx.enumDeclaration());
            statementNode.setEnumDeclaration(en);
        } else if (ctx.consolDeclaration() != null) {
            ConsolDeclaration con = (ConsolDeclaration) visit(ctx.consolDeclaration());
            statementNode.setConsolDeclaration(con);
        } else if (ctx.expressionStatement() != null) {
            ExpressionStatement exp = (ExpressionStatement) visit(ctx.expressionStatement());
            statementNode.setExpressionStatement(exp);
        } else if (ctx.returnStatement() != null) {
            ReturnStatement ret = (ReturnStatement) visit(ctx.returnStatement());
            statementNode.setReturnStatement(ret);
        } else if (ctx.throwStatement() != null) {
            ThrowStatement thr = (ThrowStatement) visit(ctx.throwStatement());
            statementNode.setThrowStatement(thr);
        } else if (ctx.objectClass() != null) {
            ObjectClass objClass = (ObjectClass) visit(ctx.objectClass());
            statementNode.setObjectClass(objClass);
        } else if (ctx.objectInterface() != null) {
            ObjectInterface objInt = (ObjectInterface) visit(ctx.objectInterface());
            statementNode.setObjectInterface(objInt);
        } else if (ctx.callFunctios() != null) {
            CallFunctios call = (CallFunctios) visit(ctx.callFunctios());
            statementNode.setCallFunctios(call);
        } else if (ctx.assignment() != null) {
            Assignment assign = (Assignment) visit(ctx.assignment());
            statementNode.setAssignment(assign);
        } else if (ctx.emitStatement() != null) {
            EmitStatement emit = (EmitStatement) visit(ctx.emitStatement());
            statementNode.setEmitStatement(emit);
        } else if (ctx.thisStatement() != null) {
            ThisStatement thisStmt = (ThisStatement) visit(ctx.thisStatement());
            statementNode.setThisStatement(thisStmt);
        }
        return statementNode;
    }

    @Override
    public Object visitDeclaration(HTMLParser.DeclarationContext ctx) {
        Declaration declarationNode = new Declaration();
        if (ctx.serviceDeclaration() != null) {
            ServiceDeclaration service = (ServiceDeclaration) visit(ctx.serviceDeclaration());
            declarationNode.setServiceDeclaration(service);
        } else if (ctx.componentDeclaration() != null) {
            ComponentDeclaration component = (ComponentDeclaration) visit(ctx.componentDeclaration());
            declarationNode.setComponentDeclaration(component);
        }
        return declarationNode;
    }

    @Override
    public Object visitComponentDeclaration(HTMLParser.ComponentDeclarationContext ctx) {
        ComponentDeclaration componentDeclaration = new ComponentDeclaration();
        List<ComponentBody> bodyList = new ArrayList<>();
        int line = ctx.getStart().getLine();

        // نضيف @Component إلى الجدولين
        symbolTable.addImportRow("decorator", null, line, null, true, true);
        symbolTable.addRow("decorator", "@Component", line, null);
symbolTable.addComponentRow("decorator","@Component",line);
        boolean hasSelector = false;

        for (HTMLParser.ComponentBodyContext bodyCtx : ctx.componentBody()) {
            // نمر على كل body ونبحث عن selector داخله
            if (bodyCtx.SELECTOR() != null && bodyCtx.STRING_CONTENT() != null) {
                hasSelector = true;
            }

            ComponentBody body = (ComponentBody) visit(bodyCtx);
            bodyList.add(body);
        }

        // ✅ التحقق: إذا مافي selector داخل جسم الكومبوننت
        if (!hasSelector) {
            System.err.printf("[Error] Component is missing selector at line %d%n", line);
        }

        componentDeclaration.setComponentBodyArrayList(bodyList);
        return componentDeclaration;
    }


    @Override
    public Object visitComponentBody(HTMLParser.ComponentBodyContext ctx) {
        ComponentBody body = new ComponentBody();
        if (ctx.SELECTOR() != null && ctx.STRING_CONTENT() != null) {
            String selector = ctx.STRING_CONTENT().getText();
            selector = selector.substring(1, selector.length() - 1);
            body.setSelector(selector);
            int line = ctx.getStart().getLine();
            symbolTable.addRow("component-property", "selector", line, selector);
        }
        if (ctx.STANDALONE() != null) {
            boolean standaloneValue = ctx.TRUE() != null;
            body.setStandalone(standaloneValue);
        }
        if (ctx.htmlProgram() != null) {
            HtmlProgram html = (HtmlProgram) visit(ctx.htmlProgram());
            body.setHtmlProgram(html);
        }
        if (ctx.arrayLiteral() != null) {
            ArrayLiteral array = (ArrayLiteral) visit(ctx.arrayLiteral());
            body.setArrayLiteral(array);
        }
        if (ctx.cssProgram() != null && !ctx.cssProgram().isEmpty()) {
            CssProgram css = (CssProgram) visit(ctx.cssProgram(0));
            body.setCssProgram(css);
        }

        return body;
    }


    @Override
    public Object visitServiceDeclaration(HTMLParser.ServiceDeclarationContext ctx) {
        ServiceDeclaration service = new ServiceDeclaration();
        String providedInText = ctx.STRING_CONTENT().getText();
        if (providedInText.startsWith("\"") || providedInText.startsWith("'")) {
            providedInText = providedInText.substring(1, providedInText.length() - 1);
        }
        service.setProvidedIn(providedInText);
        return service;
    }

    @Override
    public Object visitHtmlProgram(HTMLParser.HtmlProgramContext ctx) {
        HtmlProgram program = new HtmlProgram();
        if (ctx.htmlElement() != null && ctx.htmlElement().size() == 1) {
            HtmlElement element = (HtmlElement) visit(ctx.htmlElement(0));
            program.setHtmlElement(element);
        }
        else if (!ctx.htmlElement().isEmpty()) {
            HtmlElement element = (HtmlElement) visit(ctx.htmlElement(0));
            program.setHtmlElement(element);
        }
        return program;
    }

    @Override
    public Object visitHtmlElement(HTMLParser.HtmlElementContext ctx) {
        HtmlElement element = new HtmlElement();
        if (ctx.HTML_ELEMENT() != null) {
            element.setTagName(ctx.HTML_ELEMENT(0).getText());
        }
        for (ParseTree child : ctx.children) {
            if (child instanceof HTMLParser.AttributeContext) {
                Attribute attr = (Attribute) visit(child);
                element.getAttributes().add(attr);
            } else if (child instanceof HTMLParser.NgDirectiveContext) {
                NgDirective dir = (NgDirective) visit(child);
                element.getNgDirectives().add(dir);
            } else if (child instanceof HTMLParser.HtmlElementContext) {
                HtmlElement nested = (HtmlElement) visit(child);
                element.getChildren().add(nested);
            } else if (child instanceof HTMLParser.HtmlContentContext) {
                HtmlContent content = (HtmlContent) visit(child);
                element.getChildren().add(content);
            }
        }
        return element;
    }

    @Override
    public Object visitHtmlContent(HTMLParser.HtmlContentContext ctx) {
        HtmlContent content = new HtmlContent();
        if (ctx.INTERPOLATION() != null && !ctx.INTERPOLATION().isEmpty()) {
            List<String> interpolations = new ArrayList<>();
            for (TerminalNode interp : ctx.INTERPOLATION()) {
                interpolations.add(interp.getText());
            }
            content.setInterpolations(interpolations);
        } else if (ctx.STRING_CONTENT() != null) {
            content.setTextContent(ctx.STRING_CONTENT().getText());
        } else if (ctx.IDENTIFIER() != null && ctx.COLON() == null) {
            content.setIdentifier(ctx.IDENTIFIER().getText());
            content.setHasColonAfterIdentifier(false);
        } else if (ctx.IDENTIFIER() != null && ctx.COLON() != null) {
            content.setIdentifier(ctx.IDENTIFIER().getText());
            content.setHasColonAfterIdentifier(true);
        }
        return content;
    }


    @Override
    public Object visitAttribute(HTMLParser.AttributeContext ctx) {
        Attribute attribute = new Attribute();
        if (ctx.getTokens(HTMLParser.IDENTIFIER).size() == 1 && ctx.STRING_CONTENT() != null && ctx.ASSIGN() != null) {
            attribute.setName(ctx.IDENTIFIER().getText());
            attribute.setValue(ctx.STRING_CONTENT().getText());
            attribute.setType("normal");
        } else if (ctx.CLASS() != null) {
            attribute.setName("class");
            attribute.setValue(ctx.STRING_CONTENT().getText());
            attribute.setType("class");
        } else if (ctx.getTokens(HTMLParser.IDENTIFIER).size() == 1 && ctx.getText().contains(":") && ctx.ASSIGN() == null) {
            attribute.setName(ctx.IDENTIFIER().getText());
            attribute.setType("colon");
        } else if (ctx.LBRACKET() != null && ctx.RBRACKET() != null) {
            attribute.setName(ctx.IDENTIFIER().getText());
            attribute.setValue(ctx.STRING_CONTENT().getText());
            attribute.setType("bracket");
        } else if (ctx.LPAREN() != null && ctx.RPAREN() != null) {
            attribute.setName(ctx.IDENTIFIER().getText());
            attribute.setValue(ctx.STRING_CONTENT().getText());
            attribute.setType("paren");
        } else if (ctx.QUOTE().size() == 2) {
            attribute.setName(ctx.IDENTIFIER().getText());
            attribute.setValue(ctx.getText().split("=")[1].trim());
            attribute.setType("quoted");
        } else {
            attribute.setName("unknown");
            attribute.setValue(ctx.getText());
            attribute.setType("unhandled");
        }
        return attribute;
    }

    @Override
    public Object visitCssProgram(HTMLParser.CssProgramContext ctx) {
        CssProgram cssProgram = new CssProgram();
        List<CssRule> rules = new ArrayList<>();
        for (HTMLParser.CssRuleContext ruleCtx : ctx.cssRule()) {
            CssRule rule = (CssRule) visit(ruleCtx);
            rules.add(rule);
        }
        cssProgram.setCssRuleArrayList(rules);
        return cssProgram;
    }

    @Override
    public Object visitCssRule(HTMLParser.CssRuleContext ctx) {
        CssRule cssRule = new CssRule();
        if (ctx.selector() != null) {
            Selector selector = (Selector) visit(ctx.selector());
            if (ctx.COLON() != null && ctx.IDENTIFIER() != null) {
                selector.setValue(selector.getValue() + ":" + ctx.IDENTIFIER().getText());
            }
            cssRule.setSelector(selector);
        }
        List<CssProperty> properties = new ArrayList<>();
        if (ctx.cssProperty() != null && !ctx.cssProperty().isEmpty()) {
            for (int i = 0; i < ctx.cssProperty().size(); i++) {
                HTMLParser.CssPropertyContext propCtx = ctx.cssProperty(i);
                CssProperty property = (CssProperty) visit(propCtx);
                StringBuilder valueBuilder = new StringBuilder();
                int startIndex = -1;
                for (int j = 0; j < ctx.children.size(); j++) {
                    if (ctx.children.get(j) == propCtx) {
                        if (j + 2 < ctx.children.size()) {
                            startIndex = j + 2;
                            break;
                        }
                    }
                }
                if (startIndex != -1) {
                    for (int j = startIndex; j < ctx.children.size(); j++) {
                        String text = ctx.children.get(j).getText();
                        if (text.equals(";") || text.equals("}")) {
                            break;
                        }
                        valueBuilder.append(text).append(" ");
                    }
                    property.setValue(valueBuilder.toString().trim());
                }
                properties.add(property);
            }
        }
        if (ctx.CSS_PROPERTY() != null && !ctx.CSS_PROPERTY().isEmpty()) {
            for (int i = 0; i < ctx.CSS_PROPERTY().size(); i++) {
                String name = ctx.CSS_PROPERTY(i).getText();
                CssProperty property = new CssProperty();
                property.setName(name);
                StringBuilder valueBuilder = new StringBuilder();
                boolean valueStarted = false;
                for (int j = 0; j < ctx.children.size(); j++) {
                    ParseTree child = ctx.children.get(j);
                    if (child.getText().equals(name) && j + 2 < ctx.children.size()) {
                        for (int k = j + 2; k < ctx.children.size(); k++) {
                            String text = ctx.children.get(k).getText();
                            if (text.equals(";") || text.equals("}")) break;
                            valueBuilder.append(text).append(" ");
                        }
                        break;
                    }
                }
                property.setValue(valueBuilder.toString().trim());
                properties.add(property);
            }
        }
        if (ctx.callFunctios() != null && !ctx.callFunctios().isEmpty()) {
            for (var cfCtx : ctx.callFunctios()) {
                CallFunctios cf = (CallFunctios) visit(cfCtx);
                cssRule.setCallFunctios(cf);
            }
        }
        cssRule.setCssProperty(properties);
        return cssRule;
    }

    @Override
    public Object visitCssProperty(HTMLParser.CssPropertyContext ctx) {
        CssProperty cssProperty = new CssProperty();
        if (ctx.CSS_PROPERTY() != null) {
            cssProperty.setName(ctx.CSS_PROPERTY().getText());
        }
        return cssProperty;
    }


    @Override
    public Object visitSelector(HTMLParser.SelectorContext ctx) {
        Selector selector = new Selector();
        if (ctx.DOT() != null) {
            selector.setType("class");
            if (ctx.IDENTIFIER() != null) {
                selector.setValue("." + ctx.IDENTIFIER().getText());
            } else if (ctx.HTML_ELEMENT() != null) {
                selector.setValue("." + ctx.HTML_ELEMENT().getText());
            } else if (ctx.LOG() != null) {
                selector.setValue("." + ctx.LOG().getText());
            } else if (ctx.AS() != null) {
                selector.setValue("." + ctx.AS().getText());
            }
        } else if (ctx.HASH() != null && ctx.IDENTIFIER() != null) {
            selector.setType("id");
            selector.setValue("#" + ctx.IDENTIFIER().getText());
        } else if (ctx.IDENTIFIER() != null) {
            selector.setType("tag");
            selector.setValue(ctx.IDENTIFIER().getText());
        }
        return selector;
    }

    @Override
    public Object visitImportModelDeclaration(HTMLParser.ImportModelDeclarationContext ctx) {
        ImportModelDeclaration importModel = new ImportModelDeclaration();
        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode tn) {
                String text = tn.getText();
            }
        }
        if (ctx.IDENTIFIER() != null) {
            importModel.addImport(ctx.IDENTIFIER().getText());
        }
        if (ctx.COMPONENT() != null) {
            importModel.addImport(ctx.COMPONENT().getText());
        }
        if (ctx.INJECTABLE() != null) {
            importModel.addImport(ctx.INJECTABLE().getText());
        }

        if (ctx.STRING_CONTENT() != null) {
            importModel.setFrom(ctx.STRING_CONTENT().getText());
        }
        String importedName = ctx.IDENTIFIER() != null ? ctx.IDENTIFIER().getText() : "";
        String fullImport = ctx.getText();
        int line = ctx.getStart().getLine();

        boolean hasCurly = fullImport.contains("{");
        symbolTable.addImportRow("import", fullImport, line, importedName, true, false);

        return importModel;
    }

    @Override
    public Object visitExportModelDeclaration(HTMLParser.ExportModelDeclarationContext ctx) {
        ExportModelDeclaration exportModel = new ExportModelDeclaration();
        if (ctx.classDeclaration() != null) {
            ClassDeclaration classDecl = (ClassDeclaration) visit(ctx.classDeclaration());
            exportModel.setClassDeclaration(classDecl);
            exportModel.setExportedType("class");
            if (classDecl.getClassName() != null) {
                exportModel.setExportedName(classDecl.getClassName());
            }
            return exportModel;
        }
        if (ctx.CLASS() != null) {
            exportModel.setExportedType("class");
        } else if (ctx.FUNCTION() != null) {
            exportModel.setExportedType("function");
        } else if (ctx.CONST() != null) {
            exportModel.setExportedType("const");
        } else if (ctx.INTERFACE() != null) {
            exportModel.setExportedType("interface");
        } else if (ctx.ENUM() != null) {
            exportModel.setExportedType("enum");
        }

        if (ctx.IDENTIFIER() != null) {
            exportModel.setExportedName(ctx.IDENTIFIER().getText());
        }

        if (ctx.expression() != null) {
            Expression expr = (Expression) visit(ctx.expression());
            exportModel.setExpression(expr);
        }

        return exportModel;
    }

    @Override
    public Object visitVariableDeclaration(HTMLParser.VariableDeclarationContext ctx) {
        VariableDeclaration varDecl = new VariableDeclaration();
        if (ctx.decorator() != null) {
            Decorator decorator = (Decorator) visit(ctx.decorator());
            varDecl.setDecorator(decorator);
            return varDecl;
        }
        if (ctx.IDENTIFIER() != null && !ctx.IDENTIFIER().isEmpty()) {
            varDecl.setName(ctx.IDENTIFIER(0).getText());

        }
        if (ctx.LET() != null) varDecl.setModifier("let");
        else if (ctx.CONST() != null) varDecl.setModifier("const");
        else if (ctx.PUBLIC() != null) varDecl.setModifier("public");
        else if (ctx.PRIVATE() != null) varDecl.setModifier("private");
        else if (ctx.PROTECTED() != null) varDecl.setModifier("protected");
        if (ctx.SDOLAR() != null && ctx.THIS() != null) {
            varDecl.setThisReference(true);
        }
        if (ctx.type() != null) {
            Type type = (Type) visit(ctx.type());
            varDecl.setType(type);
        }
        if (ctx.arrayLiteral() != null) {
            ArrayLiteral array = (ArrayLiteral) visit(ctx.arrayLiteral());
            varDecl.setArrayLiteral(array);
        }
        if (ctx.tupleLiteral() != null) {
            TupleLiteral tuple = (TupleLiteral) visit(ctx.tupleLiteral());
            varDecl.setTupleLiteral(tuple);
        }
        if (ctx.enumValue() != null) {
            EnumValue enumVal = (EnumValue) visit(ctx.enumValue());
            varDecl.setEnumValue(enumVal);
        }
        if (ctx.typeAssertion() != null) {
            TypeAssertion typeAssertion = (TypeAssertion) visit(ctx.typeAssertion());
            varDecl.setTypeAssertion(typeAssertion);
        }
        if (ctx.VALUE() != null) {
            varDecl.setValue(ctx.VALUE().getText());
        } else if (ctx.STRING_CONTENT() != null) {
            varDecl.setValue(ctx.STRING_CONTENT().getText());
        } else if (ctx.TRUE() != null) {
            varDecl.setValue("true");
        } else if (ctx.FALSE() != null) {
            varDecl.setValue("false");
        }


        return varDecl;
    }

    @Override
    public Object visitDecorator(HTMLParser.DecoratorContext ctx) {
        Decorator decorator = new Decorator();
        if (ctx.IDENTIFIER(0) != null) {
            decorator.setDecoratorName(ctx.IDENTIFIER(0).getText());

        }
        if (ctx.IDENTIFIER(1) != null) {
            decorator.setTargetName(ctx.IDENTIFIER(1).getText());
        }
        if (ctx.IDENTIFIER(2) != null) {
            decorator.setClassName(ctx.IDENTIFIER(2).getText());
        }
        if (ctx.type() != null) {
            Type type = (Type) visit(ctx.type());
            decorator.setType(type);
        }
        if (ctx.IDENTIFIER(0) != null && ctx.IDENTIFIER(0).getText().equals("Component")) {



        }




        return decorator;
    }

    @Override
    public Object visitTypeAssertion(HTMLParser.TypeAssertionContext ctx) {
        TypeAssertion typeAssertion = new TypeAssertion();
        HTMLParser.TypeContext typeCtx = null;
        if (ctx.type() != null) {
            typeCtx = ctx.type();
        } else if (ctx.OPEN_TAG() != null && ctx.CLOUSE_TAG() != null && ctx.getChildCount() >= 5) {
            for (ParseTree child : ctx.children) {
                if (child instanceof HTMLParser.TypeContext) {
                    typeCtx = (HTMLParser.TypeContext) child;
                    break;
                }
            }
        }
        if (typeCtx != null) {
            Type type = (Type) visit(typeCtx);
            typeAssertion.setType(type);
        }
        return typeAssertion;
    }

    @Override
    public Object visitEnumDeclaration(HTMLParser.EnumDeclarationContext ctx) {
        EnumDeclaration enumDecl = new EnumDeclaration();
        if (ctx.enumeratorList() != null) {
            EnumeratorList list = (EnumeratorList) visit(ctx.enumeratorList());
            enumDecl.setEnumeratorList(list);
        }
        return enumDecl;
    }

    @Override
    public Object visitEnumeratorList(HTMLParser.EnumeratorListContext ctx) {
        EnumeratorList list = new EnumeratorList();
        for (TerminalNode id : ctx.IDENTIFIER()) {
            list.addEnumerator(id.getText());
        }
        return list;
    }

    @Override
    public Object visitEnumValue(HTMLParser.EnumValueContext ctx) {
        EnumValue enumValue = new EnumValue();
        enumValue.setEnumName(ctx.IDENTIFIER(0).getText());
        enumValue.setValueName(ctx.IDENTIFIER(1).getText());
        return enumValue;
    }

    @Override
    public Object visitClassDeclaration(HTMLParser.ClassDeclarationContext ctx) {
        ClassDeclaration classDecl = new ClassDeclaration();
        classDecl.setClassName(ctx.IDENTIFIER(0).getText());
        if(ctx.EXTENDS() != null) {
            classDecl.setExtendsClassName(ctx.IDENTIFIER(1).getText());
        }
        if(ctx.block() != null) {
            Block block = (Block) visit(ctx.block());
            classDecl.setBlock(block);
        }
        return classDecl;
    }

    @Override
    public Object visitObjectClass(HTMLParser.ObjectClassContext ctx) {
        ObjectClass objClass = new ObjectClass();
        objClass.setVariableName(ctx.IDENTIFIER(0).getText());
        objClass.setClassName(ctx.IDENTIFIER(1).getText());
        if(ctx.expression() != null && !ctx.expression().isEmpty()) {
            List<Expression> exprList = new ArrayList<>();
            for (HTMLParser.ExpressionContext exprCtx : ctx.expression()) {
                Expression expr = (Expression) visit(exprCtx);
                exprList.add(expr);
            }
            objClass.setExpressions(exprList);
        }
        return objClass;
    }

    @Override
    public Object visitInterfaceDeclaration(HTMLParser.InterfaceDeclarationContext ctx) {
        InterfaceDeclaration interfaceDecl = new InterfaceDeclaration();
        if (ctx.IDENTIFIER() != null) {
            interfaceDecl.setIdentifier(ctx.IDENTIFIER().getText());
        }
        if (ctx.block() != null) {
            Block block = (Block) visit(ctx.block());
            interfaceDecl.setBlock(block);
        }
        return interfaceDecl;
    }

    @Override
    public Object visitObjectInterface(HTMLParser.ObjectInterfaceContext ctx) {
        ObjectInterface objInterface = new ObjectInterface();
        if (ctx.IDENTIFIER(0) != null) {
            objInterface.setName(ctx.IDENTIFIER(0).getText());
        }
        if (ctx.IDENTIFIER(1) != null) {
            objInterface.setTypeName(ctx.IDENTIFIER(1).getText());
        }
        if (ctx.objectInterfaceBody() != null) {
            ObjectInterfaceBody body = (ObjectInterfaceBody) visit(ctx.objectInterfaceBody());
            objInterface.setObjectInterfaceBody(body);
        }
        return objInterface;
    }

    @Override
    public Object visitObjectInterfaceBody(HTMLParser.ObjectInterfaceBodyContext ctx) {
        ObjectInterfaceBody body = new ObjectInterfaceBody();
        int i = 0;
        int childCount = ctx.getChildCount();
        while (i < childCount) {
            String key = ctx.getChild(i).getText();
            i++;
            if (i >= childCount || !ctx.getChild(i).getText().equals(":")) {
                break;
            }
            i++;
            if (i >= childCount) break;
            String value = ctx.getChild(i).getText();
            body.addProperty(new ObjectInterfaceBody.Property(key, value));
            i++;
            if (i < childCount) {
                String nextToken = ctx.getChild(i).getText();
                if (nextToken.equals(",")) {
                    i++;
                }
            }
        }
        return body;
    }

    @Override
    public Object visitFunctionDeclaration(HTMLParser.FunctionDeclarationContext ctx) {
        FunctionDeclaration funcDecl = new FunctionDeclaration();
        if (ctx.FUNCTION() != null && ctx.IDENTIFIER() != null) {
            if (ctx.parameterList() != null) {
                funcDecl.setParameterList((ParameterList) visit(ctx.parameterList()));
            }
            if (ctx.type() != null) {
                funcDecl.setType((Type) visit(ctx.type()));
            }
            if (ctx.block() != null) {
                funcDecl.setBlock((Block) visit(ctx.block()));
            }
        } else if (ctx.ASSIGN() != null) {
            if (ctx.parameterList() != null) {
                funcDecl.setParameterList((ParameterList) visit(ctx.parameterList()));
            }
            if (ctx.type() != null) {
                funcDecl.setType((Type) visit(ctx.type()));
            }
            if (ctx.expression() != null) {
                funcDecl.setExpression((Expression) visit(ctx.expression()));
            } else if (ctx.block() != null) {
                funcDecl.setBlock((Block) visit(ctx.block()));
            }
        } else if (ctx.parameterList() != null && ctx.block() != null) {
            funcDecl.setParameterList((ParameterList) visit(ctx.parameterList()));
            funcDecl.setBlock((Block) visit(ctx.block()));
        }
        return funcDecl;
    }

    @Override
    public Object visitParameterList(HTMLParser.ParameterListContext ctx) {
        ParameterList paramList = new ParameterList();
        if (ctx.variableDeclaration() != null && !ctx.variableDeclaration().isEmpty()) {
            for (HTMLParser.VariableDeclarationContext varCtx : ctx.variableDeclaration()) {
                paramList.addParameter(visit(varCtx));
            }
        }
        else if (ctx.IDENTIFIER() != null && !ctx.IDENTIFIER().isEmpty()) {
            for (TerminalNode id : ctx.IDENTIFIER()) {
                paramList.addParameter(id.getText());
            }
        }
        else if (ctx.VALUE() != null && !ctx.VALUE().isEmpty()) {
            for (TerminalNode val : ctx.VALUE()) {
                paramList.addParameter(val.getText());
            }
        }
        return paramList;
    }

    @Override
    public Object visitCallFunctios(HTMLParser.CallFunctiosContext ctx) {
        CallFunctios call = new CallFunctios();
        call.setFunctionName(ctx.IDENTIFIER().getText());
        if (ctx.expression() != null && !ctx.expression().isEmpty()) {
            for (HTMLParser.ExpressionContext exprCtx : ctx.expression()) {
                Expression expr = (Expression) visit(exprCtx);
                call.addArgument(expr);
            }
        }
        return call;
    }

    @Override
    public Object visitConsolDeclaration(HTMLParser.ConsolDeclarationContext ctx) {
        ConsolDeclaration consol = new ConsolDeclaration();
        consol.addExpression((Expression) visit(ctx.expression(0)));
        for (int i = 1; i < ctx.expression().size(); i++) {
            consol.addExpression((Expression) visit(ctx.expression(i)));
        }
        return consol;
    }

    @Override
    public Object visitReturnStatement(HTMLParser.ReturnStatementContext ctx) {
        ReturnStatement returnStmt = new ReturnStatement();
        returnStmt.setExpression((Expression) visit(ctx.expression()));
        return returnStmt;
    }

    @Override
    public Object visitThrowStatement(HTMLParser.ThrowStatementContext ctx) {
        ThrowStatement throwStmt = new ThrowStatement();
        throwStmt.setExceptionName(ctx.IDENTIFIER().getText());
        throwStmt.setMessage(ctx.STRING_CONTENT().getText());
        return throwStmt;
    }

    @Override
    public Object visitExpressionStatement(HTMLParser.ExpressionStatementContext ctx) {
        ExpressionStatement exprStmt = new ExpressionStatement();
        exprStmt.setExpression((Expression) visit(ctx.expression()));
        return exprStmt;
    }

    @Override
    public Object visitExpression(HTMLParser.ExpressionContext ctx) {
        Expression expr = new Expression();
        if (ctx.callFunctios() != null) {
            expr.setCallFunctios((CallFunctios) visit(ctx.callFunctios()));
        } else if (ctx.variableDeclaration() != null) {
            expr.setVariableDeclaration((VariableDeclaration) visit(ctx.variableDeclaration()));
        } else if (ctx.IDENTIFIER() != null) {
            expr.setIdentifier(ctx.IDENTIFIER().getText());
        } else if (ctx.VALUE() != null) {
            expr.setValue(ctx.VALUE().getText());
        } else if (ctx.STRING_CONTENT() != null) {
            expr.setValue(ctx.STRING_CONTENT().getText());
        } else if (ctx.TRUE() != null) {
            expr.setBooleanValue(true);
        } else if (ctx.FALSE() != null) {
            expr.setBooleanValue(false);
        }
        return expr;
    }

    @Override
    public Object visitBlock(HTMLParser.BlockContext ctx) {
        Block block = new Block();
        for (HTMLParser.StatementContext stmtCtx : ctx.statement()) {
            Statement stmt = (Statement) visit(stmtCtx);
            block.getStatementArrayList().add(stmt);
        }
        return block;
    }

    @Override
    public Object visitThisStatement(HTMLParser.ThisStatementContext ctx) {
        ThisStatement thisStmt = new ThisStatement();
        thisStmt.setVariableName(ctx.IDENTIFIER(0).getText());
        thisStmt.setAssignedName(ctx.IDENTIFIER(1).getText());
        return thisStmt;
    }

    @Override
    public Object visitEmitStatement(HTMLParser.EmitStatementContext ctx) {
        EmitStatement emitStatement = new EmitStatement();
        ObjectLiteral objLiteral = (ObjectLiteral) visit(ctx.objectLiteral());
        emitStatement.setObjectLiteral(objLiteral);
        return emitStatement;
    }

    @Override
    public Object visitObjectLiteral(HTMLParser.ObjectLiteralContext ctx) {
        ObjectLiteral objectLiteral = new ObjectLiteral();
        List<ObjectProperty> props = new ArrayList<>();
        for (HTMLParser.ObjectPropertyContext propCtx : ctx.objectProperty()) {
            ObjectProperty prop = (ObjectProperty) visit(propCtx);
            props.add(prop);
        }
        objectLiteral.setObjectProperties(props);
        return objectLiteral;
    }

    @Override
    public Object visitObjectProperty(HTMLParser.ObjectPropertyContext ctx) {
        ObjectProperty prop = new ObjectProperty();
        prop.setKey(ctx.IDENTIFIER().getText());
        if (ctx.STRING_CONTENT() != null) {
            prop.setValue(ctx.STRING_CONTENT().getText());
        } else if (ctx.VALUE() != null) {
            prop.setValue(ctx.VALUE().getText());
        }
        return prop;
    }

    @Override
    public Object visitArrayLiteral(HTMLParser.ArrayLiteralContext ctx) {
        ArrayLiteral arrayLiteral = new ArrayLiteral();
        if (ctx.VALUE() != null && !ctx.VALUE().isEmpty()) {
            List<String> values = new ArrayList<>();
            for (TerminalNode valNode : ctx.VALUE()) {
                values.add(valNode.getText());
            }
            arrayLiteral.setValues(values);
        }
        if (ctx.STRING_CONTENT() != null && !ctx.STRING_CONTENT().isEmpty()) {
            List<String> stringContents = new ArrayList<>();
            for (TerminalNode strNode : ctx.STRING_CONTENT()) {
                stringContents.add(strNode.getText());
            }
            arrayLiteral.setStringContents(stringContents);
        }
        if (ctx.mapLiteral() != null && !ctx.mapLiteral().isEmpty()) {
            List<MapLiteral> mapLiterals = new ArrayList<>();
            for (HTMLParser.MapLiteralContext mapCtx : ctx.mapLiteral()) {
                MapLiteral mapLiteral = (MapLiteral) visitMapLiteral(mapCtx);
                mapLiterals.add(mapLiteral);
            }
            arrayLiteral.setMapLiterals(mapLiterals);
        }
        return arrayLiteral;
    }

    @Override
    public Object visitMapLiteral(HTMLParser.MapLiteralContext ctx) {
        MapLiteral mapLiteral = new MapLiteral();
        Map<String, Object> properties = new LinkedHashMap<>();
        for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
            String key = ctx.IDENTIFIER(i).getText();
            if (ctx.VALUE(i) != null) {
                properties.put(key, ctx.VALUE(i).getText());
            } else if (ctx.STRING_CONTENT(i) != null) {
                properties.put(key, ctx.STRING_CONTENT(i).getText());
            }
        }
        mapLiteral.setProperties(properties);
        return mapLiteral;
    }

    @Override
    public Object visitTupleLiteral(HTMLParser.TupleLiteralContext ctx) {
        TupleLiteral tupleLiteral = new TupleLiteral();
        List<String> values = new ArrayList<>();
        for (TerminalNode valueNode : ctx.VALUE()) {
            values.add(valueNode.getText());
        }
        tupleLiteral.setValues(values);
        return tupleLiteral;
    }

    @Override
    public Object visitNgDirective(HTMLParser.NgDirectiveContext ctx) {
        NgDirective ngDirective = new NgDirective();
        if (ctx.NG_FOR() != null) {
            ngDirective.setDirectiveName(ctx.NG_FOR().getText());
        } else if (ctx.NG_IF() != null) {
            ngDirective.setDirectiveName(ctx.NG_IF().getText());
        }
        ngDirective.setDirectiveValue(ctx.STRING_CONTENT().getText());
        return ngDirective;
    }

    @Override
    public Object visitType(HTMLParser.TypeContext ctx) {
        Type type = new Type();
        if (ctx.NUMBER() != null && ctx.LBRACKET() == null) {
            type.setName("number");
        } else if (ctx.NUMBER() != null && ctx.LBRACKET() != null) {
            type.setName("number[]");
        } else if (ctx.STRING() != null) {
            type.setName("string");
        } else if (ctx.BOOLEAN() != null) {
            type.setName("boolean");
        } else if (ctx.VOID() != null) {
            type.setName("void");
        } else if (ctx.ENUM() != null) {
            type.setName("enum");
        } else if (ctx.ANY() != null) {
            if (ctx.LBRACKET() != null) {
                type.setName("any[]");
            } else {
                type.setName("any");
            }
        } else if (ctx.ARRAY() != null) {
            type.setName("array");
            Type inner = (Type) visit(ctx.type(0));
            type.setInnerType(inner);
        } else if (ctx.LBRACKET() != null && ctx.type().size() > 1) {
            type.setName("tuple");
            List<Type> innerTypes = new ArrayList<>();
            for (HTMLParser.TypeContext innerCtx : ctx.type()) {
                innerTypes.add((Type) visit(innerCtx));
            }
            type.setTupleTypes(innerTypes);
        } else if (ctx.IDENTIFIER() != null) {
            type.setName(ctx.IDENTIFIER().getText());
        }
        return type;
    }

    @Override
    public Object visitAssignment(HTMLParser.AssignmentContext ctx) {
        Assignment assignment = new Assignment();
        if (!ctx.IDENTIFIER().isEmpty()) {
            assignment.setTarget(ctx.IDENTIFIER(0).getText());
        }
        if (ctx.expression() != null) {
            Expression expr = (Expression) visit(ctx.expression());
            assignment.setExpression(expr);
        } else if (ctx.any_type() != null && !ctx.any_type().isEmpty()) {
            List<Any_type> anyTypes = new ArrayList<>();
            for (HTMLParser.Any_typeContext anyCtx : ctx.any_type()) {
                Any_type a = (Any_type) visit(anyCtx);
                anyTypes.add(a);
            }
            assignment.setAny_typeArrayList(anyTypes);
        }
        return assignment;
    }

    @Override
    public Object visitAny_type(HTMLParser.Any_typeContext ctx) {
        Any_type anyType = new Any_type();
        if (ctx.LBRACKET() != null && ctx.product() != null && !ctx.product().isEmpty()) {
            List<Product> products = new ArrayList<>();
            for (HTMLParser.ProductContext productCtx : ctx.product()) {
                Product product = (Product) visit(productCtx);
                products.add(product);
            }
            anyType.setProductArrayList(products);
        }
        else if (ctx.VALUE() != null) {
            anyType.setRawValue(ctx.VALUE().getText());
        } else if (ctx.COLOR_CODE() != null) {
            anyType.setRawValue(ctx.COLOR_CODE().getText());
        } else if (ctx.IDENTIFIER() != null) {
            anyType.setRawValue(ctx.IDENTIFIER().getText());
        } else if (ctx.NUMBER() != null) {
            anyType.setRawValue(ctx.NUMBER().getText());
        } else if (ctx.STRING() != null) {
            anyType.setRawValue(ctx.STRING().getText());
        } else if (ctx.ANY() != null) {
            anyType.setRawValue(ctx.ANY().getText());
        }
        return anyType;
    }

    @Override
    public Object visitProduct(HTMLParser.ProductContext ctx) {
        Product product = new Product();
        if (ctx.IDENTIFIER().size() >= 3 && ctx.STRING().size() >= 2) {
            product.setKey1(ctx.IDENTIFIER(0).getText());
            if (!ctx.NUMBER().isEmpty()) {
                product.setNumberValue(ctx.NUMBER(0).getText());
            }
            product.setKey2(ctx.IDENTIFIER(1).getText());
            product.setStringValue1(ctx.STRING(0).getText());
            product.setKey3(ctx.IDENTIFIER(2).getText());
            product.setStringValue2(ctx.STRING(1).getText());
        }
        return product;
    }

    @Override
    public Object visitObjectCreation(HTMLParser.ObjectCreationContext ctx) {
        ObjectCreation objCreation = new ObjectCreation();
        objCreation.setVariableName(ctx.IDENTIFIER(0).getText());
        objCreation.setClassName(ctx.IDENTIFIER(1).getText());
        List<Expression> args = new ArrayList<>();
        for (HTMLParser.ExpressionContext exprCtx : ctx.expression()) {
            Expression expr = (Expression) visit(exprCtx);
            args.add(expr);
        }
        objCreation.setArguments(args);
        return objCreation;
    }

}
