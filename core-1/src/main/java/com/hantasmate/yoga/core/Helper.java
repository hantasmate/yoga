/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Helper
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class Helper {

  private final List<Runnable> runnables;

  private final DefaultContext defaultContext;

  private Helper() {
    this(new ArrayList<>());
  }

  private Helper(List<Runnable> runnables) {
    this.runnables = runnables;
    this.defaultContext = new DefaultContext();
  }

  public static Helper create() {
    return new Helper();
  }

  public Helper select(Consumer<SelectPart> selectConsumer) {
    runnables.add(() -> {
      DefaultSelectPart selectPart = new DefaultSelectPart(defaultContext);
      selectConsumer.accept(selectPart);
    });

    return this;
  }

  public Helper from(Consumer<FromPart> fromConsumer) {
    runnables.add(() -> {
      DefaultFromPart fromPart = new DefaultFromPart(defaultContext);
      fromConsumer.accept(fromPart);
    });
    return this;
  }

  public Helper where(Consumer<WherePart> whereConsumer) {
    runnables.add(() -> {
      DefaultWherePart wherePart = new DefaultWherePart(defaultContext);
      whereConsumer.accept(wherePart);
    });
    return this;
  }

  public Helper groupBy(Consumer<GroupPart> groupConsumer) {
    runnables.add(() -> {
      DefaultGroupPart wherePart = new DefaultGroupPart(defaultContext);
      groupConsumer.accept(wherePart);
    });
    return this;
  }

  public Helper orderBy(Consumer<OrderPart> orderConsumer) {
    runnables.add(() -> {
      DefaultOrderPart orderPart = new DefaultOrderPart(defaultContext);
      orderConsumer.accept(orderPart);
    });
    return this;
  }

  public String sql() {
    return "";
  }

  public List<String> bindValues() {
    return new ArrayList<>();
  }

  public DefaultContext context() {
    return this.defaultContext;
  }

  public void execution() {
    runnables.forEach(Runnable::run);
    // String sql = defaultContext.sql();
    // List<String> values = defaultContext.bindValues();
    // System.out.println(sql);
    // System.out.println(values);
    defaultContext.runOnContext();
  }
}
