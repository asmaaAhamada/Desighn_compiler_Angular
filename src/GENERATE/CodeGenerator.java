package GENERATE;

import AST.*;
import antlr.HTMLParser;
import antlr.HTMLParserBaseVisitor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CodeGenerator extends HTMLParserBaseVisitor<String> {

    FileWriter htmlWriter;
    FileWriter tsWriter;
    FileWriter cssWriter;

    {
        try {
            htmlWriter = new FileWriter("GeneratedComponent.component.html");
            tsWriter = new FileWriter("GeneratedComponent.component.ts");
            cssWriter = new FileWriter("GeneratedComponent.component.css");
        } catch (IOException e) {
            throw new RuntimeException("❌ Error while creating code files", e);
        }
    }

    void writeToFile(String content, FileWriter writer) {
        try {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("❌ Writing error: " + e.getMessage());
        }
    }

    void closeWriters() {
        try {
            htmlWriter.close();
            tsWriter.close();
            cssWriter.close();
        } catch (IOException e) {
            System.err.println("❌ Closing error: " + e.getMessage());
        }
    }
}