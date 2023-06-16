/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.KeyWord;

/**
 * As
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public interface As extends KeyWord {

  @Override
  default String keyword() {
    return "as";
  }
}
