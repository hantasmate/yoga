/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Context;
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

  void eq(Field name, Object value);

  void ne(Field name, Object value);

  void gt(Field name, Object value);

  void lt(Field name, Object value);

  void ge(Field name, Object value);

  void le(Field name, Object value);

  void between(Field name, Object bv, Object av);

  void like(Field name, String value);

  void leftLike(Field name, String value);

  void rightLike(Field name, String value);

  void in(Field name, Collection<Object> values);

  void isNull(Field name);

  void isNotNull(Field name);

  void or(Handler handler);

  void and(Handler handler);
}
