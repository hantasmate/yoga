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
public interface Field extends Named, Pure, Alias<Field>, Segment {

  @Override
  default Field as(String alias) {
    return this;
  }

  default Table table() {
    return null;
  }

  default int type() {
    return Types.VARCHAR;
  }

  @Override
  default boolean pure() {
    return false;
  }
}
