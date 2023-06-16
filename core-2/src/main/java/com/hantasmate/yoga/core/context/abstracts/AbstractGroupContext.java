/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.GroupContext;
import com.hantasmate.yoga.core.context.PredicateContext;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * AbstractGroupContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractGroupContext extends AbstractFieldContext implements GroupContext {

  protected AbstractGroupContext(DslContext dslContext, Handler handler) {
    super(dslContext, handler, Priority.GROUP_BY);
  }

  @Override
  public void having(Consumer<PredicateContext> havingConsumer) {
  }
}
