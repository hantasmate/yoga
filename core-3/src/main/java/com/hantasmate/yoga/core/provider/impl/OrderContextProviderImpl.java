/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider.impl;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.OrderContext;
import com.hantasmate.yoga.core.provider.AbstractContextProvider;
import com.hantasmate.yoga.core.provider.OrderContextProvider;

/**
 * OrderContextProviderImpl
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class OrderContextProviderImpl extends AbstractContextProvider<OrderContext>
    implements OrderContextProvider {

  public OrderContextProviderImpl(YogaContext context) {
    super(context);
  }

  @Override
  public void handle() {
    super.handle();
    context.sqlBuilder().append(Snippet.SPACE).append(Snippet.ORDER_BY).append(Snippet.SPACE).append(snippet());
  }
}
