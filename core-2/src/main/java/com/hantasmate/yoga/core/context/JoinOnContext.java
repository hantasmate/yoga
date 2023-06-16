/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Field;

/**
 * JoinOnContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
@FunctionalInterface
public interface JoinOnContext {

  void on(Field sf, String op, Field tf);
}
