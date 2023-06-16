/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * GroupContext
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface GroupContext extends Context {

  @Override
  default int index() {
    return 3000;
  }
}
