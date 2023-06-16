/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider.impl;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.PredicateContext;
import com.hantasmate.yoga.core.provider.AbstractContextProvider;
import com.hantasmate.yoga.core.provider.PredicateContextProvider;

/**
 * PredicateContextProviderImpl
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class PredicateContextProviderImpl extends AbstractContextProvider<PredicateContext>
    implements PredicateContextProvider<PredicateContext> {

  public PredicateContextProviderImpl(YogaContext context) {
    super(context);
  }

  @Override
  public PredicateContext provide() {
    return this;
  }
}
