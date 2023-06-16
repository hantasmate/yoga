/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider.impl;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.ValuesContext;
import com.hantasmate.yoga.core.provider.AbstractContextProvider;
import com.hantasmate.yoga.core.provider.ValuesContextProvider;

/**
 * ValuesContextProviderImpl
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public class ValuesContextProviderImpl extends AbstractContextProvider<ValuesContext>
    implements ValuesContextProvider {

  public ValuesContextProviderImpl(YogaContext context) {
    super(context);
  }
}
