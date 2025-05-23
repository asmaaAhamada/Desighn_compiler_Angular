// Generated from C:/Users/ASUS/IdeaProjects/compiler project 2/src/antlr/HTMLParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(HTMLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HTMLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(HTMLParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#componentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDeclaration(HTMLParser.ComponentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#componentBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentBody(HTMLParser.ComponentBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#serviceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceDeclaration(HTMLParser.ServiceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlProgram(HTMLParser.HtmlProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(HTMLParser.HtmlElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlContent(HTMLParser.HtmlContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#cssProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssProgram(HTMLParser.CssProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRule(HTMLParser.CssRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#cssProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssProperty(HTMLParser.CssPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(HTMLParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#importModelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportModelDeclaration(HTMLParser.ImportModelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#exportModelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportModelDeclaration(HTMLParser.ExportModelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(HTMLParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(HTMLParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#typeAssertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssertion(HTMLParser.TypeAssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(HTMLParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#enumeratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeratorList(HTMLParser.EnumeratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#enumValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumValue(HTMLParser.EnumValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(HTMLParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objectClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectClass(HTMLParser.ObjectClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(HTMLParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objectInterface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInterface(HTMLParser.ObjectInterfaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objectInterfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInterfaceBody(HTMLParser.ObjectInterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(HTMLParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(HTMLParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#callFunctios}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunctios(HTMLParser.CallFunctiosContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#consolDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsolDeclaration(HTMLParser.ConsolDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(HTMLParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(HTMLParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(HTMLParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(HTMLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(HTMLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#thisStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisStatement(HTMLParser.ThisStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#emitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmitStatement(HTMLParser.EmitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(HTMLParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objectProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectProperty(HTMLParser.ObjectPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(HTMLParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#mapLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapLiteral(HTMLParser.MapLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#tupleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleLiteral(HTMLParser.TupleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#ngDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNgDirective(HTMLParser.NgDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(HTMLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(HTMLParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#any_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_type(HTMLParser.Any_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(HTMLParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objectCreation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCreation(HTMLParser.ObjectCreationContext ctx);
}