/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.Collection;

/**
 * PredicatePart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface PredicatePart {

  default void eq(Field name, Object value) {
  }

  default void ne(Field name, Object value) {
  }

  default void gt(Field name, Object value) {
  }

  default void lt(Field name, Object value) {
  }

  default void ge(Field name, Object value) {
  }

  default void le(Field name, Object value) {
  }

  default void between(Field name, Object bv, Object av) {
  }

  default void like(Field name, String value) {
  }

  default void leftLike(Field name, String value) {
  }

  default void rightLike(Field name, String value) {
  }

  default void in(Field name, Collection<Object> values) {
  }

  default void isNull(Field name) {
  }

  default void isNotNull(Field name) {
  }

  default void or(Runnable... runnables) {
  }
}
