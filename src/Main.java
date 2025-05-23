import AST.Program;
import Visitor.VisitorCompiler;
import antlr.HTMLLexer;
import antlr.HTMLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws IOException {
        String source = "tests/test1"; // ← عدّل حسب مسار ملفك
        CharStream charStream = fromFileName(source);
        HTMLLexer htmlLexer = new HTMLLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(htmlLexer);
        HTMLParser parser = new HTMLParser(tokens);

        VisitorCompiler visitorCompiler = new VisitorCompiler();
        ParseTree ast = parser.program();
        Program program = (Program) visitorCompiler.visit(ast);

        System.out.println("\n====================== AST Tree ======================\n");
        System.out.println(program);
        System.out.println("======================================================\n");
    }
}
