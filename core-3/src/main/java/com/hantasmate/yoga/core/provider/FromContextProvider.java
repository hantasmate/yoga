/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.FromContext;

/**
 * FromContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface FromContextProvider
    extends JoinContextProvider<FromContext>, TableContextProvider<FromContext>, FromContext {

  /**
   * process closure string
   *
   * @param closure closure string
   */
  @Override
  default void doClosure(String closure) {
    if (snippet().length() == 0) {
      snippet().append(closure);
    } else {
      snippet().append(Snippet.SPACE).append(closure);
    }
  }

  @Override
  default FromContext provide() {
    return this;
  }

  @Override
  default void plain(String segment) {
    doClosure(segment);
  }
}
