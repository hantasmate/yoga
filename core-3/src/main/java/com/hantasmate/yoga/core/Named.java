/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * Named
 *
 * @author tabuyos
 * @since 2023/3/14
 */
@FunctionalInterface
public interface Named {

  String name();

  default String qualifiedName() {
    return name();
  }
}
