/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.impl;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.contant.Snippet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * AbstractTable
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractTable implements Table {

  private String alias;
  private final String name;
  private final boolean pure;
  private final List<Field> fields;

  public AbstractTable(String name) {
    this(name, false);
  }
  public AbstractTable(String name, boolean pure) {
    this(name, null, pure);
  }

  public AbstractTable(String name, String alias, boolean pure) {
    this.name = name;
    this.alias = alias;
    this.fields = new ArrayList<>();
    this.pure = pure;
  }

  @Override
  public Table as(String alias) {
    this.alias = alias;
    return this;
  }

  @Override
  public String as() {
    return alias;
  }

  @Override
  public boolean pure() {
    return pure;
  }

  @Override
  public String segment() {
    return Optional.ofNullable(alias)
        .map(alias -> name() + Snippet.S_AS_S + alias)
        .orElse(name());
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<Field> fields() {
    return fields;
  }
}
