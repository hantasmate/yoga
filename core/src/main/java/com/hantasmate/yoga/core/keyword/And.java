/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.KeyWord;
import com.hantasmate.yoga.core.concept.Quantifier;

/**
 * And
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface And extends Quantifier, KeyWord {

  @Override
  default String keyword() {
    return "and";
  }
}
