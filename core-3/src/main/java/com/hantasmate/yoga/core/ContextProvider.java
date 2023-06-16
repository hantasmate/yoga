/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ContextProvider
 *
 * @author tabuyos
 * @since 2023/3/17
 */
public interface ContextProvider<P, C, S> extends Handler {

  P provide();

  C context();

  S snippet();

  @Override
  default void handle() {}

  /**
   * process closure string
   *
   * @param closure closure string
   */
  default void doClosure(String closure) {}

  default List<Runnable> tasks() {
    return null;
  }
}
