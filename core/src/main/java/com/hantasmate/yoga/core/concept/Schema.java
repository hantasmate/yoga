/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

/**
 * Schema
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Schema extends Concept {

  default String name() {
    return null;
  }
}
