/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * FromContext
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface FromContext extends Context {

  @Override
  default int index() {
    return 1000;
  }
}
