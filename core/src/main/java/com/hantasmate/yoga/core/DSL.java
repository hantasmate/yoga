/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import com.hantasmate.yoga.core.concept.Context;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.KeyWord;
import com.hantasmate.yoga.core.concept.Operator;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.concept.Predicate;
import com.hantasmate.yoga.core.concept.Quantifier;
import com.hantasmate.yoga.core.concept.Table;
import com.hantasmate.yoga.core.concept.impl.FieldImpl;
import com.hantasmate.yoga.core.concept.impl.KeyWordImpl;
import com.hantasmate.yoga.core.concept.impl.OrderImpl;
import com.hantasmate.yoga.core.concept.impl.PredicateImpl;
import com.hantasmate.yoga.core.concept.impl.TableImpl;
import com.hantasmate.yoga.core.enums.JoinType;
import com.hantasmate.yoga.core.keyword.impl.AndImpl;
import com.hantasmate.yoga.core.keyword.impl.OrImpl;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * DSL
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class DSL {

  public static Table table(Context context) {
    return new TableImpl(context);
  }

  public static Table table(String name) {
    return new TableImpl(name);
  }

  public static Table join(Table table) {
    return new TableImpl(table.name(), table.schema(), table.database(), table.alias(), JoinType.INNER_JOIN);
  }

  public static Table crossJoin(Table table) {
    return new TableImpl(table.name(), table.schema(), table.database(), table.alias(), JoinType.CROSS_JOIN);
  }

  public static Table innerJoin(Table table) {
    return new TableImpl(table.name(), table.schema(), table.database(), table.alias(), JoinType.INNER_JOIN);
  }

  public static Table leftJoin(Table table) {
    return new TableImpl(table.name(), table.schema(), table.database(), table.alias(), JoinType.LEFT_JOIN);
  }

  public static Table rightJoin(Table table) {
    return new TableImpl(table.name(), table.schema(), table.database(), table.alias(), JoinType.RIGHT_JOIN);
  }

  public static Table fullJoin(Table table) {
    return new TableImpl(table.name(), table.schema(), table.database(), table.alias(), JoinType.FULL_JOIN);
  }

  public static Field field(String name) {
    return new FieldImpl(name);
  }

  public static Field field(String name, Table table) {
    return new FieldImpl(name, table);
  }

  public static Field funcField(String func) {
    return new FieldImpl(func);
  }

  public static Field funcField(String funcTemplate, Field... field) {
    String newField = MessageFormat.format(funcTemplate, Arrays.stream(field).map(Field::name).toArray());
    return new FieldImpl(newField);
  }

  public static KeyWord keyword(String keyword) {
    return new KeyWordImpl(keyword);
  }

  public static Predicate and(Predicate... predicates) {
    return new PredicateImpl(new AndImpl(), predicates);
  }

  public static Predicate or(Predicate... predicates) {
    return new PredicateImpl(new OrImpl(), predicates);
  }

  public static Order order(Field field) {
    return order(field, true);
  }

  public static Order order(Field field, boolean asc) {
    return new OrderImpl(field, asc);
  }

  public static Operator operator(String op) {
    return () -> op;
  }

  public static Quantifier quantifier(String quantifier) {
    return () -> quantifier;
  }

  public static <V> Predicate predicate(String field, String operator, V value) {
    return predicate(field(field), operator, value);
  }

  public static <V> Predicate predicate(Field field, String op, V value) {
    return new PredicateImpl(field, operator(op), value);
  }

  public static <V> Predicate eq(Field field, V value) {
    return predicate(field, "=", value);
  }
}
