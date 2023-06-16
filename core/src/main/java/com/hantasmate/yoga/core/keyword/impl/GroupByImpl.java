/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword.impl;

import com.hantasmate.yoga.core.concept.Context;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.keyword.GroupBy;
import com.hantasmate.yoga.core.keyword.OrderBy;

import java.util.StringJoiner;

/**
 * GroupByImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class GroupByImpl implements GroupBy {

  private final Context context;

  public GroupByImpl(Context context) {
    this.context = context;
    this.context.addPart(this);
  }

  @Override
  public OrderBy orderBy(Order... orders) {
    return new OrderByImpl(context());
  }

  @Override
  public Context context() {
    return context;
  }

  @Override
  public void process(StringJoiner sqlJoiner) {

  }
}
