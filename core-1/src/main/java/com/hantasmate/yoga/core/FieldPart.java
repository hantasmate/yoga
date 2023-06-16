/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * FieldPart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface FieldPart {

  default void field(String name, String alias) {
  }

  default void field(Field name) {
  }

  default void field(String... names) {
  }

  default void field(Field... names) {
  }
}
