/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider.impl;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.SelectContext;
import com.hantasmate.yoga.core.provider.AbstractContextProvider;
import com.hantasmate.yoga.core.provider.SelectContextProvider;

/**
 * SelectContextProviderImpl
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class SelectContextProviderImpl extends AbstractContextProvider<SelectContext>
    implements SelectContextProvider {

  public SelectContextProviderImpl(YogaContext context) {
    super(context);
  }

  @Override
  public void handle() {
    super.handle();
    context.sqlBuilder().append(Snippet.SELECT).append(Snippet.SPACE).append(snippet());
  }
}
