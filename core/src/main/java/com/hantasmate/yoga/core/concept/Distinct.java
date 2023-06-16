/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

/**
 * Distinct
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public interface Distinct extends KeyWord {

  @Override
  default String keyword() {
    return "distinct";
  }
}
