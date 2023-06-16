/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.SelectContext;

/**
 * AbstractSelectContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractSelectContext extends AbstractFieldContext implements SelectContext {

  protected AbstractSelectContext(DslContext dslContext, Handler handler) {
    super(dslContext, handler, Priority.SELECT);
  }
}
