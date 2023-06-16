/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

import java.util.List;

/**
 * Predicate
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Predicate extends Concept {

  Quantifier quantifier();
  Field field();
  Operator operator();
  Object value();
  List<Predicate> pairs();
  boolean isBare();
}
