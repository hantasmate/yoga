/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.YogaContext;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractContextProvider
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public abstract class AbstractContextProvider<T> implements ContextProvider<T, YogaContext, StringBuilder> {

  protected final YogaContext context;
  protected final StringBuilder snippet;
  protected final List<Runnable> tasks;

  public AbstractContextProvider(YogaContext context) {
    this.context = context;
    this.snippet = new StringBuilder();
    this.tasks = new ArrayList<>();
  }

  @Override
  public YogaContext context() {
    return context;
  }

  @Override
  public StringBuilder snippet() {
    return snippet;
  }

  @Override
  public List<Runnable> tasks() {
    return tasks;
  }

  @Override
  public void handle() {
    tasks().forEach(Runnable::run);
  }
}
