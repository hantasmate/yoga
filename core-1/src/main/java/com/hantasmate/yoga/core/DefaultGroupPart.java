/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * DefaultGroupPart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class DefaultGroupPart implements GroupPart {

  private final DefaultContext context;
  private final List<Field> fields;

  public DefaultGroupPart(DefaultContext context) {
    this.context = context;
    this.fields = new ArrayList<>();
    GroupContext whereContext = this::doContext;
    this.context.appendContext(whereContext);
  }

  @Override
  public void having(Consumer<PredicatePart> havingConsumer) {
    System.out.println("having");
    havingConsumer.accept(new DefaultPredicatePart(context));
  }

  private void doContext() {
    System.out.println("call group by part...");
  }
}
