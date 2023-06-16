/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept.impl;

import com.hantasmate.yoga.core.concept.KeyWord;

/**
 * KeyWordImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class KeyWordImpl implements KeyWord {

  private final String keyword;

  public KeyWordImpl(String keyword) {
    this.keyword = keyword;
  }

  @Override
  public String keyword() {
    return keyword;
  }
}
