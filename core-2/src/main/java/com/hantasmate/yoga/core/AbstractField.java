/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import com.hantasmate.yoga.core.contant.Snippet;

import java.util.Optional;

/**
 * AbstractField
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractField implements Field {
  private String alias;
  private final String name;
  private final Table table;

  public AbstractField(String name) {
    this(name, null);
  }

  public AbstractField(String name, Table table) {
    this(name, null, table);
  }

  public AbstractField(String name, String alias, Table table) {
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
    Optional<Table> tableOptional = Optional.ofNullable(table());
    String tableName = tableOptional.map(Table::name).map(name -> name + Snippet.DOT).orElse("");
    String tableDef =
        tableOptional.map(Alias::as).map(alias -> alias + Snippet.DOT).orElse(tableName);
    return tableDef
        + Optional.ofNullable(alias)
            .map(as -> name() + Snippet.SPACE + Snippet.AS + Snippet.SPACE + as)
            .orElse(name());
  }

  @Override
  public String name() {
    return name;
  }
}
