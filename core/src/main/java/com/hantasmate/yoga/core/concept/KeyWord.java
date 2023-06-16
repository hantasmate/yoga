/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

/**
 * KeyWord
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface KeyWord extends Concept {

  default String keyword() {
    return "";
  }
}
