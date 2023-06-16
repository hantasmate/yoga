/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.FieldContext;
import com.hantasmate.yoga.core.impl.FieldImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * AbstractFieldContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractFieldContext implements FieldContext {

  protected final DslContext dslContext;
  protected final List<Field> fields;
  protected final StringBuilder snippet;
  private final StringJoiner joiner;

  protected AbstractFieldContext(DslContext dslContext, Handler handler, int priority) {
    this.dslContext = dslContext;
    this.fields = new ArrayList<>();
    this.snippet = new StringBuilder();
    this.joiner = new StringJoiner(", ");
    this.dslContext.addHandler(Optional.ofNullable(handler).orElse(this::handle), priority);
  }

  @Override
  public void field(String name, String alias) {
    joiner.add(Optional.ofNullable(alias).filter(as -> as.length() > 0).map(as -> name + Snippet.S_AS_S + as).orElse(name));
  }

  @Override
  public void field(Field name) {
    joiner.add(name.piece());
  }

  @Override
  public void field(String... names) {
    Arrays.stream(names).forEach(joiner::add);
  }

  @Override
  public void field(Field... names) {
    Arrays.stream(names).map(Field::piece).forEach(joiner::add);
  }

  protected void handle() {
    System.out.println(snippet.append(joiner));
  }
}
