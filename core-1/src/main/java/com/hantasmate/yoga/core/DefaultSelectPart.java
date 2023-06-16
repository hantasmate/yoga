/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DefaultSelectPart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class DefaultSelectPart implements SelectPart {

  private final DefaultContext context;
  private final List<Field> fields;

  public DefaultSelectPart(DefaultContext context) {
    this.context = context;
    this.fields = new ArrayList<>();
    SelectContext selectContext = this::doContext;
    this.context.appendContext(selectContext);
  }

  @Override
  public void field(String name, String alias) {
    Field field = new DefaultField(name);
    field.as(alias);
    fields.add(field);
  }

  @Override
  public void field(Field name) {
    fields.add(name);
  }

  @Override
  public void field(String... names) {
    Arrays.stream(names).<Field>map(DefaultField::new).forEach(fields::add);
  }

  @Override
  public void field(Field... names) {
    fields.addAll(Arrays.stream(names).collect(Collectors.toList()));
  }

  private void doContext() {
    System.out.println("call select part...");
    fields.forEach(
        f -> {
          System.out.println(f.piece());
          // System.out.println(f.table());
          // System.out.println(f.as());
        });
  }
}
