/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.sql.Types;

/**
 * Field
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface Field extends Named, Alias<Field>, Piece {

  @Override
  default Field as(String as) {
    return this;
  }

  default Table table() {
    return null;
  }

  default int type() {
    return Types.VARCHAR;
  }

  @Override
  default String piece() {
    return name();
  }
}
