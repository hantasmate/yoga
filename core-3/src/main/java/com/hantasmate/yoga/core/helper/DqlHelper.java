/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.helper;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.FromContext;
import com.hantasmate.yoga.core.context.GroupContext;
import com.hantasmate.yoga.core.context.OrderContext;
import com.hantasmate.yoga.core.context.SelectContext;
import com.hantasmate.yoga.core.context.WhereContext;
import com.hantasmate.yoga.core.pair.BindPair;
import com.hantasmate.yoga.core.provider.FromContextProvider;
import com.hantasmate.yoga.core.provider.GroupContextProvider;
import com.hantasmate.yoga.core.provider.OrderContextProvider;
import com.hantasmate.yoga.core.provider.SelectContextProvider;
import com.hantasmate.yoga.core.provider.WhereContextProvider;
import com.hantasmate.yoga.core.provider.impl.FromContextProviderImpl;
import com.hantasmate.yoga.core.provider.impl.GroupContextProviderImpl;
import com.hantasmate.yoga.core.provider.impl.OrderContextProviderImpl;
import com.hantasmate.yoga.core.provider.impl.SelectContextProviderImpl;
import com.hantasmate.yoga.core.provider.impl.WhereContextProviderImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * DqlHelper
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class DqlHelper {

  private final List<Runnable> tasks;

  private final YogaContext context;

  private DqlHelper() {
    this(new ArrayList<>());
  }

  private DqlHelper(List<Runnable> tasks) {
    this.tasks = tasks;
    this.context = new YogaContext();
  }

  public static DqlHelper create() {
    return new DqlHelper();
  }

  public DqlHelper select(Consumer<SelectContext> selectConsumer) {
    tasks.add(
        () -> {
          SelectContextProvider provider = new SelectContextProviderImpl(context);
          context.contextParts().add(provider);
          context.addHandler(provider, Priority.SELECT);
          selectConsumer.accept(provider.provide());
        });
    return this;
  }

  public DqlHelper from(Consumer<FromContext> fromConsumer) {
    tasks.add(
        () -> {
          FromContextProvider provider = new FromContextProviderImpl(context);
          context.contextParts().add(provider);
          context.addHandler(provider, Priority.FROM);
          fromConsumer.accept(provider.provide());
        });
    return this;
  }

  public DqlHelper where(Consumer<WhereContext> whereConsumer) {
    tasks.add(
        () -> {
          WhereContextProvider provider = new WhereContextProviderImpl(context);
          context.contextParts().add(provider);
          context.addHandler(provider, Priority.WHERE);
          whereConsumer.accept(provider.provide());
        });
    return this;
  }

  public DqlHelper groupBy(Consumer<GroupContext> groupConsumer) {
    tasks.add(
        () -> {
          GroupContextProvider provider = new GroupContextProviderImpl(context);
          context.contextParts().add(provider);
          context.addHandler(provider, Priority.GROUP_BY);
          groupConsumer.accept(provider.provide());
        });
    return this;
  }

  public DqlHelper orderBy(Consumer<OrderContext> orderConsumer) {
    tasks.add(
        () -> {
          OrderContextProvider provider = new OrderContextProviderImpl(context);
          context.contextParts().add(provider);
          context.addHandler(provider, Priority.ORDER_BY);
          orderConsumer.accept(provider.provide());
        });
    return this;
  }

  public DqlHelper plainSql(String sql) {
    context.sqlBuilder().append(sql);
    return this;
  }

  public DqlHelper plainSql(String sql, BindPair... bindPairs) {
    context.sqlBuilder().append(sql);
    context.bindValues().addAll(Arrays.asList(bindPairs));
    return this;
  }

  private void prepareExecution() {
    tasks.forEach(Runnable::run);
    context().prepareContext();
  }

  public YogaContext context() {
    return this.context;
  }

  public void execution() {
    prepareExecution();
    System.out.println(context().plainSql());
    System.out.println(context().bindValues());
  }
}
