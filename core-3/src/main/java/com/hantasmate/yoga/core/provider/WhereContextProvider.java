/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.context.WhereContext;

/**
 * WhereContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface WhereContextProvider extends PredicateContextProvider<WhereContext>, WhereContext {
  @Override
  default WhereContext provide() {
    return this;
  }

  @Override
  default void plain(String segment) {
    doClosure(segment);
  }
}
