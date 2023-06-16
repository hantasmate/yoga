/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Context;

import java.util.function.Consumer;

/**
 * HavingContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public interface HavingContext extends Context {

  void having(Consumer<PredicateContext> havingConsumer);
}
