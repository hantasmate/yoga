/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept.impl;

import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Order;

/**
 * OrderImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class OrderImpl implements Order {

  private Field field;
  private boolean asc;

  public OrderImpl(Field field, boolean asc) {
    this.field = field;
    this.asc = asc;
  }

  @Override
  public Field field() {
    return field;
  }

  @Override
  public boolean asc() {
    return asc;
  }
}
