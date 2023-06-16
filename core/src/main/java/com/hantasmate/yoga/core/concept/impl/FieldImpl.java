/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept.impl;

import com.hantasmate.yoga.core.concept.Alias;
import com.hantasmate.yoga.core.concept.Database;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Schema;
import com.hantasmate.yoga.core.concept.Table;

/**
 * FieldImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class FieldImpl implements Field {

  private final String name;
  private Table table;
  private Schema schema;
  private Database database;
  private Alias alias;

  public FieldImpl(String name) {
    this.name = name;
  }

  public FieldImpl(String name, Table table) {
    this.name = name;
    this.table = table;
  }

  public FieldImpl(String name, Table table, Schema schema, Database database) {
    this.name = name;
    this.table = table;
    this.schema = schema;
    this.database = database;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Table table() {
    return table;
  }

  @Override
  public Schema schema() {
    return schema;
  }

  @Override
  public Database database() {
    return database;
  }

  @Override
  public Alias alias() {
    return alias;
  }

  @Override
  public Field as(String alias) {
    this.alias = () -> alias;
    return this;
  }
}
