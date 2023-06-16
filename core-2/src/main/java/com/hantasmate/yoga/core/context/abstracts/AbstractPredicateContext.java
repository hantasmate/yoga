/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.PredicateContext;
import com.hantasmate.yoga.core.enums.OperatorType;
import com.hantasmate.yoga.core.enums.QuantifierType;
import com.hantasmate.yoga.core.tuple.TwoTuple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * AbstractPredicateContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractPredicateContext implements PredicateContext {

  protected final DslContext dslContext;
  protected final List<TwoTuple<Integer, Object>> bindValues;

  protected final StringBuilder builder;

  protected AbstractPredicateContext(DslContext dslContext, Handler handler) {
    this(dslContext, handler, Priority.WHERE);
  }

  protected AbstractPredicateContext(DslContext dslContext, Handler handler, int priority) {
    this.dslContext = dslContext;
    this.bindValues = new ArrayList<>();
    this.dslContext.addHandler(Optional.ofNullable(handler).orElse(this::handle), priority);
    this.builder = new StringBuilder();
  }

  @Override
  public void eq(Field name, Object value) {
    StringJoiner tj = new StringJoiner(" ");
    tj.add(name.piece()).add(OperatorType.EQ.operator()).add("?");
    builder.append(tj).append(" ").append(QuantifierType.AND.quantifier()).append(" ");
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void ne(Field name, Object value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void gt(Field name, Object value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void lt(Field name, Object value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void ge(Field name, Object value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void le(Field name, Object value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void between(Field name, Object bv, Object av) {
    bindValues.add(TwoTuple.of(name.type(), bv));
    bindValues.add(TwoTuple.of(name.type(), av));
  }

  @Override
  public void like(Field name, String value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void leftLike(Field name, String value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void rightLike(Field name, String value) {
    bindValues.add(TwoTuple.of(name.type(), value));
  }

  @Override
  public void in(Field name, Collection<Object> values) {
    values.forEach(
        v -> {
          bindValues.add(TwoTuple.of(name.type(), v));
        });
  }

  @Override
  public void isNull(Field name) {}

  @Override
  public void isNotNull(Field name) {}

  @Override
  public void or(Handler handler) {
    builder.setLength(builder.length() - 5);
    builder.append(" or (");
    handler.handle();
    builder.setLength(builder.length() - 5);
    builder.append(") ");
  }

  @Override
  public void and(Handler handler) {
    builder.setLength(builder.length() - 5);
    builder.append(" and (");
    handler.handle();
    builder.setLength(builder.length() - 5);
    builder.append(") ");
  }

  protected void handle() {
    this.retrieve();
    System.out.println(builder);
    bindValues.forEach(
        v -> {
          // System.out.println(v);
        });
  }

  private void retrieve() {
    Optional.ofNullable(builder)
        .filter(b -> b.length() > 0)
        .map(StringBuilder::toString)
        .map(String::trim)
        .ifPresent(
            any -> {
              if (any.endsWith(QuantifierType.OR.quantifier())) {
                builder.setLength(builder.length() - (QuantifierType.OR.quantifier().length() + 2));
                return;
              }
              if (any.endsWith(QuantifierType.AND.quantifier())) {
                builder.setLength(
                    builder.length() - (QuantifierType.AND.quantifier().length() + 2));
              }
            });
  }
}
