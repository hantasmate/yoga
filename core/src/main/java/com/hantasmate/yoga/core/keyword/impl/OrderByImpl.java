/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword.impl;

import com.hantasmate.yoga.core.concept.Context;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.keyword.OrderBy;

import java.util.StringJoiner;

/**
 * OrderByImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class OrderByImpl implements OrderBy {

  private final Context context;

  public OrderByImpl(Context context) {
    this.context = context;
    this.context.addPart(this);
  }

  @Override
  public OrderBy orderBy(Order... orders) {
    return this;
  }

  @Override
  public Context context() {
    return context;
  }

  @Override
  public void process(StringJoiner sqlJoiner) {

  }
}
