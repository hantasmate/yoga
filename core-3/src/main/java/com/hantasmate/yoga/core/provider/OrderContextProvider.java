/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.OrderContext;

/**
 * OrderContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface OrderContextProvider
    extends ContextProvider<OrderContext, YogaContext, StringBuilder>, OrderContext {

  @Override
  default void doClosure(String closure) {
    if (snippet().length() == 0) {
      snippet().append(closure);
    } else {
      snippet().append(Snippet.COMMA_S).append(closure);
    }
  }

  @Override
  default OrderContext provide() {
    return this;
  }

  @Override
  default void desc(String name) {
    doClosure(name + Snippet.SPACE + Snippet.DESC);
  }

  @Override
  default void desc(Field field) {
    doClosure(field.qualifiedName() + Snippet.SPACE + Snippet.DESC);
  }

  @Override
  default void asc(String name) {
    doClosure(name + Snippet.SPACE + Snippet.ASC);
  }

  @Override
  default void asc(Field field) {
    doClosure(field.qualifiedName() + Snippet.SPACE + Snippet.ASC);
  }

  @Override
  default void plain(String segment) {
    doClosure(segment);
  }
}
