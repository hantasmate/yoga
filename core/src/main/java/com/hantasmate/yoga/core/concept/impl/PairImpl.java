/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept.impl;

import com.hantasmate.yoga.core.concept.Pair;

/**
 * PairImpl
 *
 * @author tabuyos
 * @since 2023/3/9
 */
public class PairImpl implements Pair {

  private final Class<?> type;
  private final Object value;

  public PairImpl(Class<?> type, Object value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public Class<?> type() {
    return type;
  }

  @Override
  public Object value() {
    return value;
  }
}
