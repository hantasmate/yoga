/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.impl;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.context.abstracts.AbstractSelectContext;

/**
 * SelectContextImpl
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class SelectContextImpl extends AbstractSelectContext {

  public SelectContextImpl(DslContext dslContext) {
    super(dslContext, null);
  }
}
