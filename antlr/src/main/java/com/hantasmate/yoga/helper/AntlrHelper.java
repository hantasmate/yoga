/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.helper;

import antlr.MySqlLexer;
import antlr.MySqlParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * AntlrHelper
 *
 * @author tabuyos
 * @since 2023/3/25
 */
public class AntlrHelper {
  public static void main(String[] args) {
    CodePointCharStream charStream = CharStreams.fromString("select *, id, name, age from one_t;");
    MySqlLexer sqlLexer = new MySqlLexer(charStream);
    sqlLexer.setTokenFactory(new CommonTokenFactory(true));
    CommonTokenStream tokens = new CommonTokenStream(sqlLexer);
    MySqlParser parser = new MySqlParser(tokens);
    // MySqlParser.DeleteStatementContext deleteStatementContext = parser.deleteStatement();
    MySqlParser.SelectStatementContext selectStatementContext = parser.selectStatement();
    CustomizeMySqlParserVisitor visitor = new CustomizeMySqlParserVisitor();
    TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
    // CustomizeMySqlParserListener listener = new CustomizeMySqlParserListener(rewriter);
    // ParseTreeWalker walker = new ParseTreeWalker();
    // walker.walk(listener, selectStatementContext);
    String visit = visitor.visit(selectStatementContext);
    // String deleteStatement = visitor.visitSingleDeleteStatement(deleteStatementContext.singleDeleteStatement());
    visitor.visit(selectStatementContext);
    // System.out.println(deleteStatement);
    System.out.println(visit);
    System.out.println(sqlLexer.getInputStream());
    System.out.println(rewriter.getText());
  }
}
