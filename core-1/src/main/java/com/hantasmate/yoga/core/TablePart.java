/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * TablePart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface TablePart {

  default void table(String name, String alias) {
  }

  default void table(Table name) {
  }

  default void table(String... names) {
  }

  default void table(Table... names) {
  }

  default void table(DefaultContext dc) {
  }
}
