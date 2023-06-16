/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * OpType
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public enum OpType {
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

  private final String op;

  OpType(String op) {
    this.op = op;
  }

  public String op() {
    return op;
  }
}
