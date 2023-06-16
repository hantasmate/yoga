/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.helper;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.SelectContext;
import com.hantasmate.yoga.core.provider.SelectContextProvider;
import com.hantasmate.yoga.core.provider.impl.SelectContextProviderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * DmlHelper
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public class DmlHelper {

  private final List<Runnable> tasks;

  private final YogaContext context;

  private DmlHelper() {
    this(new ArrayList<>());
  }

  private DmlHelper(List<Runnable> tasks) {
    this.tasks = tasks;
    this.context = new YogaContext();
  }

  public static DmlHelper create() {
    return new DmlHelper();
  }

  public DmlHelper insert(Consumer<SelectContext> selectConsumer) {
    tasks.add(
      () -> {
        SelectContextProvider provider = new SelectContextProviderImpl(context);
        context.contextParts().add(provider);
        context.addHandler(provider, Priority.SELECT);
        selectConsumer.accept(provider.provide());
      });
    return this;
  }
}
