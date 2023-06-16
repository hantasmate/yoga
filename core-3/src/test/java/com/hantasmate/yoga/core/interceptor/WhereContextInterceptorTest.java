/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.interceptor;

import com.hantasmate.yoga.core.context.WhereContext;
import com.hantasmate.yoga.core.impl.FieldImpl;

import java.sql.Types;

/**
 * WhereContextInterceptorTest
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class WhereContextInterceptorTest extends WhereContextInterceptor {

  @Override
  public void doIntercept(WhereContext context) {
    context.eq(new FieldImpl("age", Types.INTEGER), 123);
  }
}
