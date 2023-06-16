/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.interceptor;

import com.hantasmate.yoga.core.ContextInterceptor;
import com.hantasmate.yoga.core.context.Context;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * AbstractContextInterceptor
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public abstract class AbstractContextInterceptor<T extends Context> implements ContextInterceptor {

  @SuppressWarnings("unchecked")
  protected Class<T> parameterizedType() {
    Type genericSuperclass = getClass().getGenericSuperclass();
    if (genericSuperclass instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
      if (parameterizedType
          .getRawType()
          .getTypeName()
          .equals(AbstractContextInterceptor.class.getTypeName())) {
        Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
        if (actualTypeArgument instanceof Class<?>) {
          return (Class<T>) actualTypeArgument;
        }
      }
    }
    return null;
  }
}
