/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.Optional;

/**
 * DefaultField
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class DefaultField implements Field {

  private String alias;
  private final String name;
  private final Table table;

  public DefaultField(String name) {
    this(name, null);
  }

  public DefaultField(String name, Table table) {
    this(name, null, table);
  }

  public DefaultField(String name, String alias, Table table) {
    this.name = name;
    this.alias = alias;
    this.table = table;
  }

  @Override
  public Field as(String as) {
    this.alias = as;
    return this;
  }

  @Override
  public Table table() {
    return table;
  }

  @Override
  public String piece() {
    String tableDef = Optional.ofNullable(table()).map(Alias::as).map(as -> as + ".").orElseGet(() -> Optional.ofNullable(table()).map(Table::name).map(name -> name + ".").orElse(""));
    return tableDef + Optional.ofNullable(alias).map(as -> name() + " as " + as).orElse(name());
  }

  @Override
  public String name() {
    return name;
  }
}
