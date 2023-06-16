/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.enums;

/**
 * Keyword
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public enum Keyword {

  /**
   * DISTINCT
   */
  DISTINCT("distinct"),
  /**
   * ALL
   */
  ALL("all"),
  /**
   * SQL_CALC_FOUND_ROWS
   */
  SQL_CALC_FOUND_ROWS("sql_calc_found_rows");

  private final String keyword;

  Keyword(String keyword) {
    this.keyword = keyword;
  }

  public String keyword() {
    return keyword;
  }
}
