/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.impl;

import com.hantasmate.yoga.core.Alias;
import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.contant.Snippet;

import java.sql.Types;
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
  private final boolean pure;
  private final Table table;
  private final int type;

  public AbstractField(String name) {
    this(name, Types.VARCHAR, false);
  }

  public AbstractField(String name, boolean pure) {
    this(name, Types.VARCHAR, pure);
  }

  public AbstractField(String name, int type, boolean pure) {
    this(name, type, null, pure);
  }

  public AbstractField(String name, int type, Table table, boolean pure) {
    this(name, null, type, table, pure);
  }

  public AbstractField(String name, String alias, int type, Table table) {
    this(name, alias, type, table, false);
  }

  public AbstractField(String name, String alias, int type, Table table, boolean pure) {
    this.name = name;
    this.alias = alias;
    this.table = table;
    this.type = type;
    this.pure = pure;
    Optional.ofNullable(this.table).map(Table::fields).ifPresent(fields -> fields.add(this));
  }

  @Override
  public Field as(String alias) {
    this.alias = alias;
    return this;
  }

  @Override
  public String as() {
    return alias;
  }

  @Override
  public int type() {
    return type;
  }

  @Override
  public Table table() {
    return table;
  }

  @Override
  public String segment() {
    return Optional.ofNullable(alias)
        .map(alias -> qualifiedName() + Snippet.S_AS_S + alias)
        .orElse(qualifiedName());
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String qualifiedName() {
    Optional<Table> tableOptional = Optional.ofNullable(table());
    String tableName = tableOptional.map(Table::name).map(name -> name + Snippet.DOT).orElse("");
    String tablePart =
        tableOptional.map(Alias::as).map(alias -> alias + Snippet.DOT).orElse(tableName);

    return tablePart + name();
  }
}
