/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.OrderContext;

import java.util.Optional;

/**
 * AbstractOrderContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractOrderContext implements OrderContext {

  protected final DslContext dslContext;
  protected final StringBuilder builder;

  protected AbstractOrderContext(DslContext dslContext, Handler handler) {
    this.dslContext = dslContext;
    this.dslContext.addHandler(Optional.ofNullable(handler).orElse(this::handle), Priority.ORDER_BY);
    this.builder = new StringBuilder();
  }

  @Override
  public void desc(String name) {

  }

  @Override
  public void desc(Field name) {

  }

  @Override
  public void asc(String name) {

  }

  @Override
  public void asc(Field name) {

  }

  protected void handle() {
  }
}
