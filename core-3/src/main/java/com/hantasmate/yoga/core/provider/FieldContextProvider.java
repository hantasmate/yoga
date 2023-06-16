/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.FieldContext;
import com.hantasmate.yoga.core.impl.FieldImpl;

import java.sql.Types;
import java.util.Arrays;

/**
 * FieldContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface FieldContextProvider<P>
    extends ContextProvider<P, YogaContext, StringBuilder>, FieldContext {

  /**
   * process closure string
   *
   * @param closure closure string
   */
  @Override
  default void doClosure(String closure) {
    String trimSnippet = snippet().toString().trim();
    if (trimSnippet.length() == 0) {
      snippet().append(closure);
    } else {
      snippet().append(Snippet.COMMA_S).append(closure);
    }
  }

  @Override
  default void field(String name, String alias) {
    Field field = new FieldImpl(name, alias, Types.VARCHAR, null);
    context().fields().add(field);
    doClosure(field.segment());
  }

  @Override
  default void field(Field field) {
    context().fields().add(field);
    doClosure(field.segment());
  }

  @Override
  default void field(String... names) {
    Arrays.stream(names)
        .map(FieldImpl::new)
        .peek(context().fields()::add)
        .map(Field::segment)
        .forEach(this::doClosure);
  }

  @Override
  default void field(Field... fields) {
    Arrays.stream(fields)
        .peek(context().fields()::add)
        .map(Field::segment)
        .forEach(this::doClosure);
  }

  @Override
  default void plain(String segment) {
    doClosure(segment);
  }
}
