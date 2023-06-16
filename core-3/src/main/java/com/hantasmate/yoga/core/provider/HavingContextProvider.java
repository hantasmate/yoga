/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.context.HavingContext;
import com.hantasmate.yoga.core.context.PredicateContext;

import java.util.function.Consumer;

/**
 * HavingContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface HavingContextProvider<T>
    extends PredicateContextProvider<T>, HavingContext {

  @Override
  default void having(Consumer<PredicateContext> havingConsumer) {

  }
}
