/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.helper;

import antlr.MySqlParser;
import antlr.MySqlParserBaseVisitor;
import antlr.MySqlParserVisitor;
import org.antlr.v4.runtime.CommonToken;

/**
 * CustomizeMySqlParserVisitor
 *
 * @author tabuyos
 * @since 2023/3/25
 */
public class CustomizeMySqlParserVisitor extends MySqlParserBaseVisitor<String> {

  @Override
  public String visitParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx) {
    System.out.println("12321");
    return super.visitParenthesisSelect(ctx);
  }

  @Override
  public String visitSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
    System.out.println(ctx.querySpecification().SELECT().getSymbol().getClass());
    System.out.println(ctx.querySpecification().selectElements().selectElement(0).getClass());
    System.out.println(ctx.querySpecification().selectElements().selectElement(0).getText());
    // CommonToken commonToken = new CommonToken(ctx.querySpecification().selectElements().selectElement(0));
    System.out.println(ctx.querySpecification().selectElements().STAR());
    System.out.println("32123");
    return "ok";
  }

  @Override
  public String visitSingleDeleteStatement(MySqlParser.SingleDeleteStatementContext ctx) {
    System.out.println(666);
    return "delete";
  }
}
