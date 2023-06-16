/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.UpdateContext;

/**
 * UpdateContextProvider
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public interface UpdateContextProvider
    extends ContextProvider<UpdateContext, YogaContext, StringBuilder>, UpdateContext {

  @Override
  default UpdateContext provide() {
    return this;
  }

  @Override
  default void plain(String segment) {
    snippet().append(segment);
  }
}
