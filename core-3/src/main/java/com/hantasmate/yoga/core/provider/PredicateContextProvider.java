/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.PredicateContext;
import com.hantasmate.yoga.core.enums.OperatorType;
import com.hantasmate.yoga.core.pair.BindPair;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * PredicateContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface PredicateContextProvider<T>
    extends ContextProvider<T, YogaContext, StringBuilder>, PredicateContext {

  /**
   * process closure string
   *
   * @param closure closure string
   */
  default void doClosure(StringJoiner closure) {
    doClosure(closure.toString());
  }

  /**
   * process closure string
   *
   * @param closure closure string
   */
  @Override
  default void doClosure(String closure) {
    if (snippet().length() == 0 || snippet().toString().trim().endsWith(Snippet.LEFT_PARENTHESES)) {
      snippet().append(closure);
    } else {
      snippet().append(Snippet.S_AND_S).append(closure);
    }
    // if (snippet().length() == 0) {
    //
    // snippet().append(Snippet.LEFT_PARENTHESES).append(closure).append(Snippet.RIGHT_PARENTHESES);
    // } else if (snippet().toString().trim().endsWith(Snippet.LEFT_PARENTHESES)) {
    //   snippet().append(closure).append(Snippet.RIGHT_PARENTHESES);
    // } else {
    //   if (snippet().toString().endsWith(Snippet.RIGHT_PARENTHESES)) {
    //     snippet().deleteCharAt(snippet().lastIndexOf(Snippet.RIGHT_PARENTHESES));
    //   }
    //   snippet().append(Snippet.S_AND_S).append(closure).append(Snippet.RIGHT_PARENTHESES);
    // }
  }

  default void doCommonPredicate(Field field, Object value, String operator) {
    StringJoiner closure = new StringJoiner(Snippet.SPACE);
    closure.add(field.segment()).add(operator).add(Snippet.PLACEHOLDER);
    doClosure(closure);
    context().bindValues().add(BindPair.of(value, field.type()));
  }

  @Override
  default void eq(Field field, Object value) {
    doCommonPredicate(field, value, OperatorType.EQ.operator());
  }

  @Override
  default void ne(Field field, Object value) {
    doCommonPredicate(field, value, OperatorType.NE.operator());
  }

  @Override
  default void gt(Field field, Object value) {
    doCommonPredicate(field, value, OperatorType.GT.operator());
  }

  @Override
  default void lt(Field field, Object value) {
    doCommonPredicate(field, value, OperatorType.LT.operator());
  }

  @Override
  default void ge(Field field, Object value) {
    doCommonPredicate(field, value, OperatorType.GE.operator());
  }

  @Override
  default void le(Field field, Object value) {
    doCommonPredicate(field, value, OperatorType.LE.operator());
  }

  @Override
  default void between(Field field, Object bv, Object av) {
    StringJoiner closure = new StringJoiner(Snippet.SPACE);
    closure
        .add(field.segment())
        .add(OperatorType.BETWEEN.operator())
        .add(Snippet.PLACEHOLDER)
        .add(Snippet.AND)
        .add(Snippet.PLACEHOLDER);
    doClosure(closure);
    context().bindValues().add(BindPair.of(bv, field.type()));
    context().bindValues().add(BindPair.of(av, field.type()));
  }

  @Override
  default void like(Field field, String value) {
    String likeValue = Optional.ofNullable(value).map(v -> "%" + value + "%").orElse("");
    doCommonPredicate(field, likeValue, OperatorType.LIKE.operator());
  }

  @Override
  default void leftLike(Field field, String value) {
    String likeValue = Optional.ofNullable(value).map(v -> "%" + value).orElse("");
    doCommonPredicate(field, likeValue, OperatorType.EQ.operator());
  }

  @Override
  default void rightLike(Field field, String value) {
    String likeValue = Optional.ofNullable(value).map(v -> value + "%").orElse("");
    doCommonPredicate(field, likeValue, OperatorType.EQ.operator());
  }

  @Override
  default void in(Field field, Collection<Object> values) {
    StringJoiner closure = new StringJoiner(Snippet.SPACE);
    StringJoiner inClosure =
        new StringJoiner(Snippet.COMMA_S, Snippet.LEFT_PARENTHESES, Snippet.RIGHT_PARENTHESES);
    Optional.ofNullable(values).orElse(Collections.emptyList()).stream()
        .filter(Objects::nonNull)
        .forEach(
            value -> {
              inClosure.add(Snippet.PLACEHOLDER);
              context().bindValues().add(BindPair.of(value, field.type()));
            });

    closure.add(field.segment()).add(OperatorType.IN.operator()).add(inClosure.toString());
    doClosure(closure);
  }

  @Override
  default void isNull(Field field) {
    StringJoiner closure = new StringJoiner(Snippet.SPACE);
    closure.add(field.segment()).add(OperatorType.IS_NULL.operator());
    doClosure(closure);
  }

  @Override
  default void isNotNull(Field field) {
    StringJoiner closure = new StringJoiner(Snippet.SPACE);
    closure.add(field.segment()).add(OperatorType.IS_NOT_NULL.operator());
    doClosure(closure);
  }

  @Override
  default void plain(String segment) {
    doClosure(segment);
  }

  @Override
  default void alwaysTrue() {
    plain("1 = 1");
  }

  @Override
  default void alwaysFalse() {
    plain("1 <> 1");
  }

  @Override
  default void or(Handler handler) {
    snippet().append(Snippet.S_OR_S).append(Snippet.LEFT_PARENTHESES);
    handler.handle();
    snippet().append(Snippet.RIGHT_PARENTHESES);
  }

  @Override
  default void and(Handler handler) {
    if (snippet().length() == 0) {
      snippet().append(Snippet.LEFT_PARENTHESES);
    } else {
      snippet().append(Snippet.S_AND_S).append(Snippet.LEFT_PARENTHESES);
    }
    handler.handle();
    snippet().append(Snippet.RIGHT_PARENTHESES);
  }
}
