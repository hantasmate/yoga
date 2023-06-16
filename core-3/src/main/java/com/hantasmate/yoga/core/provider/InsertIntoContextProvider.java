/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.InsertIntoContext;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * IntoContextProvider
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public interface InsertIntoContextProvider
    extends ContextProvider<InsertIntoContext, YogaContext, StringBuilder>, InsertIntoContext {

  @Override
  default InsertIntoContext provide() {
    return this;
  }

  @Override
  default void into(Table table) {
    context().tables().add(table);
    context().fields().addAll(table.fields());
    snippet().append(table.segment());
  }

  @Override
  default void into(Table table, Field... fields) {
    context().tables().add(table);
    Arrays.stream(fields).forEach(context().fields()::add);
    StringJoiner joiner = new StringJoiner(Snippet.COMMA_S, Snippet.LEFT_PARENTHESES, Snippet.RIGHT_PARENTHESES);
    Arrays.stream(fields).map(Field::name).forEach(joiner::add);
    snippet().append(table.segment()).append(joiner);
  }

  @Override
  default void plain(String segment) {
    snippet().append(segment);
  }
}
