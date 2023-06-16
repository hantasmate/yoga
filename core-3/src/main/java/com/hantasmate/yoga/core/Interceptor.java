/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.function.Supplier;

/**
 * Interceptor
 *
 * @author tabuyos
 * @since 2023/3/7
 */
@FunctionalInterface
public interface Interceptor {

  void intercept();
}
