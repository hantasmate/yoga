/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * OrderContext
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface OrderContext extends Index {

  @Override
  default int index() {
    return 4000;
  }
}
