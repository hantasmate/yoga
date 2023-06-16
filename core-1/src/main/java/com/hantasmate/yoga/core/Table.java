/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * Table
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface Table extends Named, Alias<Table>, Piece {

  @Override
  default Table as(String as) {
    return null;
  }

  @Override
  default String piece() {
    return name();
  }
}
