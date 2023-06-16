/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * Alias
 *
 * @author tabuyos
 * @since 2023/3/15
 */
@FunctionalInterface
public interface Alias<T> {

  T as(String as);

  default String as() {
    return null;
  }
}
