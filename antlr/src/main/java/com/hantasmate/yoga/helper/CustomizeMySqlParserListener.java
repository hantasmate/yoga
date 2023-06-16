/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.helper;

import antlr.MySqlParser;
import antlr.MySqlParserBaseListener;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * CustomizeMySqlParserListener
 *
 * @author tabuyos
 * @since 2023/3/25
 */
public class CustomizeMySqlParserListener extends MySqlParserBaseListener {

  private final TokenStreamRewriter rewriter;

  public CustomizeMySqlParserListener(TokenStreamRewriter rewriter) {
    this.rewriter = rewriter;
  }

  @Override
  public void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
    rewriter.insertBefore(ctx.querySpecification().selectElements().STAR().getSymbol(), "1-1 ");
  }
}
