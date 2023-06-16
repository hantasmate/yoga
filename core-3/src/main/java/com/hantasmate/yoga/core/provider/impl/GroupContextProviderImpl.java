/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider.impl;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.GroupContext;
import com.hantasmate.yoga.core.provider.AbstractContextProvider;
import com.hantasmate.yoga.core.provider.GroupContextProvider;

/**
 * GroupContextProviderImpl
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class GroupContextProviderImpl extends AbstractContextProvider<GroupContext>
    implements GroupContextProvider {

  public GroupContextProviderImpl(YogaContext context) {
    super(context);
  }

  @Override
  public void handle() {
    super.handle();
    context.sqlBuilder().append(Snippet.SPACE).append(Snippet.GROUP_BY).append(Snippet.SPACE).append(snippet());
  }
}
