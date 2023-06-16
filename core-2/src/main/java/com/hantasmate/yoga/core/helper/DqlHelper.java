/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.helper;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.context.FromContext;
import com.hantasmate.yoga.core.context.GroupContext;
import com.hantasmate.yoga.core.context.OrderContext;
import com.hantasmate.yoga.core.context.SelectContext;
import com.hantasmate.yoga.core.context.WhereContext;
import com.hantasmate.yoga.core.context.impl.FromContextImpl;
import com.hantasmate.yoga.core.context.impl.GroupContextImpl;
import com.hantasmate.yoga.core.context.impl.OrderContextImpl;
import com.hantasmate.yoga.core.context.impl.SelectContextImpl;
import com.hantasmate.yoga.core.context.impl.WhereContextImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * DqlHelper
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class DqlHelper {

  private final List<Runnable> runnables;

  private final DslContext dslContext;

  private DqlHelper() {
    this(new ArrayList<>());
  }

  private DqlHelper(List<Runnable> runnables) {
    this.runnables = runnables;
    this.dslContext = new DslContext();
  }

  public static DqlHelper create() {
    return new DqlHelper();
  }

  public DqlHelper select(Consumer<SelectContext> selectConsumer) {
    runnables.add(() -> selectConsumer.accept(new SelectContextImpl(dslContext)));

    return this;
  }

  public DqlHelper from(Consumer<FromContext> fromConsumer) {
    runnables.add(() -> fromConsumer.accept(new FromContextImpl(dslContext)));
    return this;
  }

  public DqlHelper where(Consumer<WhereContext> whereConsumer) {
    runnables.add(() -> whereConsumer.accept(new WhereContextImpl(dslContext)));
    return this;
  }

  public DqlHelper groupBy(Consumer<GroupContext> groupConsumer) {
    runnables.add(() -> groupConsumer.accept(new GroupContextImpl(dslContext)));
    return this;
  }

  public DqlHelper orderBy(Consumer<OrderContext> orderConsumer) {
    runnables.add(() -> orderConsumer.accept(new OrderContextImpl(dslContext)));
    return this;
  }

  public String sql() {
    return "";
  }

  public List<String> bindValues() {
    return new ArrayList<>();
  }

  public DslContext context() {
    return this.dslContext;
  }

  public void execution() {
    runnables.forEach(Runnable::run);
    dslContext.doHandle();
  }
}
