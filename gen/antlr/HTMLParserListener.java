// Generated from C:/Users/ASUS/IdeaProjects/compiler project 2/src/antlr/HTMLParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLParser}.
 */
public interface HTMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTMLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(HTMLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(HTMLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HTMLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HTMLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(HTMLParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(HTMLParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#componentDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterComponentDeclaration(HTMLParser.ComponentDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#componentDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitComponentDeclaration(HTMLParser.ComponentDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#componentBody}.
	 * @param ctx the parse tree
	 */
	void enterComponentBody(HTMLParser.ComponentBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#componentBody}.
	 * @param ctx the parse tree
	 */
	void exitComponentBody(HTMLParser.ComponentBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#serviceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterServiceDeclaration(HTMLParser.ServiceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#serviceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitServiceDeclaration(HTMLParser.ServiceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlProgram}.
	 * @param ctx the parse tree
	 */
	void enterHtmlProgram(HTMLParser.HtmlProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlProgram}.
	 * @param ctx the parse tree
	 */
	void exitHtmlProgram(HTMLParser.HtmlProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElement(HTMLParser.HtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElement(HTMLParser.HtmlElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContent(HTMLParser.HtmlContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContent(HTMLParser.HtmlContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#cssProgram}.
	 * @param ctx the parse tree
	 */
	void enterCssProgram(HTMLParser.CssProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#cssProgram}.
	 * @param ctx the parse tree
	 */
	void exitCssProgram(HTMLParser.CssProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRule(HTMLParser.CssRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRule(HTMLParser.CssRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#cssProperty}.
	 * @param ctx the parse tree
	 */
	void enterCssProperty(HTMLParser.CssPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#cssProperty}.
	 * @param ctx the parse tree
	 */
	void exitCssProperty(HTMLParser.CssPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(HTMLParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(HTMLParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#importModelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportModelDeclaration(HTMLParser.ImportModelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#importModelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportModelDeclaration(HTMLParser.ImportModelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#exportModelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportModelDeclaration(HTMLParser.ExportModelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#exportModelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportModelDeclaration(HTMLParser.ExportModelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(HTMLParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(HTMLParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(HTMLParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(HTMLParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#typeAssertion}.
	 * @param ctx the parse tree
	 */
	void enterTypeAssertion(HTMLParser.TypeAssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#typeAssertion}.
	 * @param ctx the parse tree
	 */
	void exitTypeAssertion(HTMLParser.TypeAssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(HTMLParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(HTMLParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratorList(HTMLParser.EnumeratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratorList(HTMLParser.EnumeratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#enumValue}.
	 * @param ctx the parse tree
	 */
	void enterEnumValue(HTMLParser.EnumValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#enumValue}.
	 * @param ctx the parse tree
	 */
	void exitEnumValue(HTMLParser.EnumValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(HTMLParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(HTMLParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#objectClass}.
	 * @param ctx the parse tree
	 */
	void enterObjectClass(HTMLParser.ObjectClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#objectClass}.
	 * @param ctx the parse tree
	 */
	void exitObjectClass(HTMLParser.ObjectClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(HTMLParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(HTMLParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#objectInterface}.
	 * @param ctx the parse tree
	 */
	void enterObjectInterface(HTMLParser.ObjectInterfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#objectInterface}.
	 * @param ctx the parse tree
	 */
	void exitObjectInterface(HTMLParser.ObjectInterfaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#objectInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterObjectInterfaceBody(HTMLParser.ObjectInterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#objectInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitObjectInterfaceBody(HTMLParser.ObjectInterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(HTMLParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(HTMLParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(HTMLParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(HTMLParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#callFunctios}.
	 * @param ctx the parse tree
	 */
	void enterCallFunctios(HTMLParser.CallFunctiosContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#callFunctios}.
	 * @param ctx the parse tree
	 */
	void exitCallFunctios(HTMLParser.CallFunctiosContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#consolDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConsolDeclaration(HTMLParser.ConsolDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#consolDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConsolDeclaration(HTMLParser.ConsolDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(HTMLParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(HTMLParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(HTMLParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(HTMLParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(HTMLParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(HTMLParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(HTMLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(HTMLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(HTMLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(HTMLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#thisStatement}.
	 * @param ctx the parse tree
	 */
	void enterThisStatement(HTMLParser.ThisStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#thisStatement}.
	 * @param ctx the parse tree
	 */
	void exitThisStatement(HTMLParser.ThisStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#emitStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmitStatement(HTMLParser.EmitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#emitStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmitStatement(HTMLParser.EmitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(HTMLParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(HTMLParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void enterObjectProperty(HTMLParser.ObjectPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void exitObjectProperty(HTMLParser.ObjectPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(HTMLParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(HTMLParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#mapLiteral}.
	 * @param ctx the parse tree
	 */
	void enterMapLiteral(HTMLParser.MapLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#mapLiteral}.
	 * @param ctx the parse tree
	 */
	void exitMapLiteral(HTMLParser.MapLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTupleLiteral(HTMLParser.TupleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTupleLiteral(HTMLParser.TupleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#ngDirective}.
	 * @param ctx the parse tree
	 */
	void enterNgDirective(HTMLParser.NgDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#ngDirective}.
	 * @param ctx the parse tree
	 */
	void exitNgDirective(HTMLParser.NgDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(HTMLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(HTMLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(HTMLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(HTMLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(HTMLParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(HTMLParser.Any_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#product}.
	 * @param ctx the parse tree
	 */
	void enterProduct(HTMLParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#product}.
	 * @param ctx the parse tree
	 */
	void exitProduct(HTMLParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void enterObjectCreation(HTMLParser.ObjectCreationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void exitObjectCreation(HTMLParser.ObjectCreationContext ctx);
}