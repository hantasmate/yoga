/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * Context
 *
 * @author tabuyos
 * @since 2023/3/15
 */
@FunctionalInterface
public interface Context extends Index {

  void doContext();

  @Override
  default int index() {
    return 0;
  }
}
