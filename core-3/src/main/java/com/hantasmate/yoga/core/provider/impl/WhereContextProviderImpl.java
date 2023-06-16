/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider.impl;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.WhereContext;
import com.hantasmate.yoga.core.provider.AbstractContextProvider;
import com.hantasmate.yoga.core.provider.WhereContextProvider;

/**
 * WhereContextProviderImpl
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class WhereContextProviderImpl extends AbstractContextProvider<WhereContext>
    implements WhereContextProvider {

  public WhereContextProviderImpl(YogaContext context) {
    super(context);
  }

  @Override
  public void handle() {
    super.handle();
    context.sqlBuilder().append(Snippet.SPACE).append(Snippet.WHERE).append(Snippet.SPACE).append(snippet());
  }
}
