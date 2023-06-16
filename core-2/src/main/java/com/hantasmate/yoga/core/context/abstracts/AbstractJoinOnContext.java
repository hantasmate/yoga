/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.context.JoinOnContext;

/**
 * AbstractJoinOnContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractJoinOnContext implements JoinOnContext {
  @Override
  public void on(Field sf, String op, Field tf) {

  }
}
