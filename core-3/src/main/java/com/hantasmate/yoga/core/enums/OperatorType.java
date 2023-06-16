/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.enums;

/**
 * OperatorType
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public enum OperatorType {
  /** = */
  EQ("="),
  /** <> */
  NE("<>"),
  /** > */
  GT(">"),
  /** < */
  LT("<"),
  /** >= */
  GE(">="),
  /** <= */
  LE("<="),
  /** between */
  BETWEEN("between"),
  /** and */
  AND("and"),
  /** like */
  LIKE("like"),
  /** in */
  IN("in"),
  /** is null */
  IS_NULL("is null"),
  /** is not null */
  IS_NOT_NULL("is not null"),
  /** as */
  AS("as");

  private final String operator;

  OperatorType(String operator) {
    this.operator = operator;
  }

  public String operator() {
    return operator;
  }
}
