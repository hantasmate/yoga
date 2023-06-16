/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

/**
 * Order
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public interface Order extends Concept {

  Field field();
  boolean asc();
}
