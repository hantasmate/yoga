/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * SelectContext
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface SelectContext extends Context {

  default void field(String name) {
  }

  @Override
  default int index() {
    return 0;
  }
}
