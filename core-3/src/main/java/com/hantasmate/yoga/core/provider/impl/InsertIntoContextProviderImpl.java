/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider.impl;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.InsertIntoContext;
import com.hantasmate.yoga.core.provider.AbstractContextProvider;
import com.hantasmate.yoga.core.provider.InsertIntoContextProvider;

/**
 * InsertContextProviderImpl
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public class InsertIntoContextProviderImpl extends AbstractContextProvider<InsertIntoContext>
    implements InsertIntoContextProvider {

  public InsertIntoContextProviderImpl(YogaContext context) {
    super(context);
  }

  @Override
  public void handle() {
    super.handle();
    context
        .sqlBuilder()
        .append(Snippet.INSERT)
        .append(Snippet.SPACE)
        .append(Snippet.INTO)
        .append(Snippet.SPACE)
        .append(snippet());
  }
}
