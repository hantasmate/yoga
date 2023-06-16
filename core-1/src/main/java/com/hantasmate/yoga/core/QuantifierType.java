/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * QuantifierType
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public enum QuantifierType {

  /**
   * and
   */
  AND("and"),
  /**
   * or
   */
  OR("or");

  private final String quantifier;

  QuantifierType(String quantifier) {
    this.quantifier = quantifier;
  }

  public String quantifier() {
    return quantifier;
  }
}
