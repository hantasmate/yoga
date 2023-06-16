/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept.impl;

import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Operator;
import com.hantasmate.yoga.core.concept.Predicate;
import com.hantasmate.yoga.core.concept.Quantifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PredicateImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class PredicateImpl implements Predicate {

  private Quantifier quantifier;
  private Field field;
  private Operator operator;
  private Object value;
  private boolean bare = false;

  private List<Predicate> pairs;

  public PredicateImpl(Quantifier quantifier, Predicate... predicates) {
    this.pairs = Arrays.stream(predicates).collect(Collectors.toList());
    this.quantifier = quantifier;
  }

  public <V> PredicateImpl(Field field, Operator operator, V value) {
    this.field = field;
    this.operator = operator;
    this.value = value;
    if (value instanceof Field) {
      this.bare = true;
    }
  }

  public <V> PredicateImpl(Field field, Operator operator, V value, boolean bare) {
    this.field = field;
    this.operator = operator;
    this.value = value;
    this.bare = bare;
  }

  @Override
  public Quantifier quantifier() {
    return quantifier;
  }

  @Override
  public Field field() {
    return field;
  }

  @Override
  public Operator operator() {
    return operator;
  }

  @Override
  public Object value() {
    return value;
  }

  @Override
  public List<Predicate> pairs() {
    return pairs;
  }

  @Override
  public boolean isBare() {
    return bare;
  }
}
