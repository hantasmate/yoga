/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * DefaultWherePart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class DefaultWherePart implements WherePart {

  private final DefaultContext context;
  private final List<Tuple<Integer, Object>> bindValues;

  private final StringBuilder builder;

  public DefaultWherePart(DefaultContext context) {
    this.context = context;
    this.bindValues = new ArrayList<>();
    WhereContext whereContext = this::doContext;
    this.context.appendContext(whereContext);
    this.builder = new StringBuilder();
  }

  @Override
  public void eq(Field name, Object value) {
    StringJoiner tj = new StringJoiner(" ");
    tj.add(name.piece()).add(OpType.EQ.op()).add("?");
    builder.append(tj).append(" ").append(QuantifierType.AND.quantifier()).append(" ");
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void ne(Field name, Object value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void gt(Field name, Object value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void lt(Field name, Object value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void ge(Field name, Object value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void le(Field name, Object value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void between(Field name, Object bv, Object av) {
    bindValues.add(Tuple.of(name.type(), bv));
    bindValues.add(Tuple.of(name.type(), av));
  }

  @Override
  public void like(Field name, String value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void leftLike(Field name, String value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void rightLike(Field name, String value) {
    bindValues.add(Tuple.of(name.type(), value));
  }

  @Override
  public void in(Field name, Collection<Object> values) {
    values.forEach(v -> {
      bindValues.add(Tuple.of(name.type(), v));
    });
  }

  @Override
  public void isNull(Field name) {
  }

  @Override
  public void isNotNull(Field name) {
  }

  @Override
  public void or(Runnable... runnables) {
    builder.setLength(builder.length() - 5);
    builder.append(" or (");
    Arrays.stream(Optional.ofNullable(runnables).orElse(new Runnable[]{})).forEach(Runnable::run);
    builder.setLength(builder.length() - 5);
    builder.append(") ");
  }

  private void doContext() {
    this.retrieve();
    System.out.println("call where part...");
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
            builder.setLength(builder.length() - (QuantifierType.AND.quantifier().length() + 2));
          }
        });
  }
}
