/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Table
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface Table extends Named, Pure, Alias<Table>, Segment {

  @Override
  default Table as(String alias) {
    return null;
  }

  default List<Field> fields() {
    return new ArrayList<>();
  }

  @Override
  default boolean pure() {
    return false;
  }
}
