/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * DefaultOrderPart
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class DefaultOrderPart implements OrderPart {

  private final DefaultContext context;

  public DefaultOrderPart(DefaultContext context) {
    this.context = context;
    GroupContext whereContext = this::doContext;
    this.context.appendContext(whereContext);
  }

  private void doContext() {
    System.out.println("call group by part...");
  }
}
