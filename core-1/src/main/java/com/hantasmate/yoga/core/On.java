/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * On
 *
 * @author tabuyos
 * @since 2023/3/15
 */
@FunctionalInterface
public interface On {

  Table on(Field sf, String op, Field tf);
}
