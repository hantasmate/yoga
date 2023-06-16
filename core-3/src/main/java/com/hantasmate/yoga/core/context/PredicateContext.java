/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Handler;

import java.util.Collection;

/**
 * PredicateContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public interface PredicateContext extends Context {

  void eq(Field field, Object value);

  void ne(Field field, Object value);

  void gt(Field field, Object value);

  void lt(Field field, Object value);

  void ge(Field field, Object value);

  void le(Field field, Object value);

  void between(Field field, Object bv, Object av);

  void like(Field field, String value);

  void leftLike(Field field, String value);

  void rightLike(Field field, String value);

  void in(Field field, Collection<Object> values);

  void isNull(Field field);

  void isNotNull(Field field);

  void alwaysTrue();

  void alwaysFalse();

  void or(Handler handler);

  void and(Handler handler);
}
