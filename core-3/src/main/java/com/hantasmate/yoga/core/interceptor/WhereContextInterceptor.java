/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.interceptor;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.WhereContext;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.provider.impl.WhereContextProviderImpl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * WhereContextInterceptor
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class WhereContextInterceptor extends AbstractContextInterceptor<WhereContext> {

  @Override
  public void intercept(YogaContext context) {

    List<WhereContext> contexts =
        context.contextParts().stream()
            .filter(ctx -> ctx instanceof WhereContext)
            .map(WhereContext.class::cast)
            .collect(Collectors.toList());
    if (contexts.size() == 0) {
      WhereContextProviderImpl provider = new WhereContextProviderImpl(context);
      context.contextParts().add(provider);
      contexts.add(provider.provide());
    }
    contexts.forEach(this::doIntercept);
  }

  public void doIntercept(WhereContext context) {
  }
}
