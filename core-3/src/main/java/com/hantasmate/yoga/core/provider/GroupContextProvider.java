/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.GroupContext;
import com.hantasmate.yoga.core.context.PredicateContext;
import com.hantasmate.yoga.core.provider.impl.PredicateContextProviderImpl;

import java.util.function.Consumer;

/**
 * GroupContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface GroupContextProvider extends FieldContextProvider<GroupContext>, GroupContext {
  @Override
  default GroupContext provide() {
    return this;
  }

  @Override
  default void having(Consumer<PredicateContext> havingConsumer) {
    PredicateContextProvider<PredicateContext> provider =
        new PredicateContextProviderImpl(context());
    havingConsumer.accept(provider.provide());
    snippet()
        .append(Snippet.SPACE)
        .append(Snippet.HAVING)
        .append(Snippet.SPACE)
        .append(provider.snippet());
  }
}
