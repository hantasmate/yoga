/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.KeyWord;
import com.hantasmate.yoga.core.concept.Quantifier;

/**
 * Or
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Or extends Quantifier, KeyWord {

  @Override
  default String keyword() {
    return "or";
  }
}
