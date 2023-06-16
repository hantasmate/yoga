/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.SetContext;

/**
 * SetContextProvider
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public interface SetContextProvider extends ContextProvider<SetContext, YogaContext, StringBuilder>, SetContext {

  @Override
  default SetContext provide() {
    return this;
  }

  @Override
  default void plain(String segment) {
    snippet().append(segment);
  }
}
