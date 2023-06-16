/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import com.hantasmate.yoga.core.interceptor.AbstractContextInterceptor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ContextInterceptor
 *
 * @author tabuyos
 * @since 2023/3/19
 */
@FunctionalInterface
public interface ContextInterceptor extends Interceptor {

  void intercept(YogaContext context);

  @Override
  default void intercept() {}

  // default void dispatcher(YogaContext context) {
  //   Class<T> ctxType = this.type();
  //   List<T> contexts =
  //       context.contextParts().stream()
  //           .peek(System.out::println)
  //           .filter(ctx -> ctx.getClass().isAssignableFrom(ctxType))
  //           .map(ctxType::cast)
  //           .collect(Collectors.toList());
  //   contexts.forEach(this::intercept);
  // }

  // @SuppressWarnings("unchecked")
  // default Class<T> type() {
  //   Type[] genericInterfaces = getClass().getGenericInterfaces();
  //   for (Type genericInterface : genericInterfaces) {
  //     if (genericInterface instanceof ParameterizedType) {
  //       ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
  //       if (parameterizedType
  //           .getRawType()
  //           .getTypeName()
  //           .equals(ContextInterceptor.class.getTypeName())) {
  //         Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
  //         if (actualTypeArgument instanceof Class<?>) {
  //           return (Class<T>) actualTypeArgument;
  //         }
  //       }
  //     }
  //   }
  //   Type genericSuperclass = getClass().getGenericSuperclass();
  //   if (genericSuperclass instanceof ParameterizedType) {
  //     ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
  //     if (parameterizedType
  //         .getRawType()
  //         .getTypeName()
  //         .equals(AbstractContextInterceptor.class.getTypeName())) {
  //       Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
  //       if (actualTypeArgument instanceof Class<?>) {
  //         return (Class<T>) actualTypeArgument;
  //       }
  //     }
  //   }
  //   return null;
  // }
}
