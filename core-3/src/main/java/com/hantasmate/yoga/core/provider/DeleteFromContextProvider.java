/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.DeleteFromContext;

/**
 * DeleteFromContextProvider
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public interface DeleteFromContextProvider
    extends ContextProvider<DeleteFromContext, YogaContext, StringBuilder>, DeleteFromContext {
  @Override
  default DeleteFromContext provide() {
    return this;
  }

  @Override
  default void plain(String segment) {
    snippet().append(segment);
  }
}
