/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept.impl;

import com.hantasmate.yoga.core.DSL;
import com.hantasmate.yoga.core.concept.Alias;
import com.hantasmate.yoga.core.concept.Context;
import com.hantasmate.yoga.core.concept.Database;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Predicate;
import com.hantasmate.yoga.core.concept.Schema;
import com.hantasmate.yoga.core.concept.Table;
import com.hantasmate.yoga.core.enums.JoinType;

/**
 * TableImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class TableImpl implements Table {

  private String name;
  private Schema schema;
  private Database database;
  private Alias alias;
  private Context context;
  private JoinType type;
  private Predicate joinPredicate;

  public TableImpl() {
  }

  public TableImpl(Context context) {
    context.enableJoin();
    this.context = context;
  }

  public TableImpl(String name) {
    this.name = name;
  }

  public TableImpl(String name, Schema schema, Database database, Alias alias, JoinType type) {
    this.name = name;
    this.schema = schema;
    this.database = database;
    this.alias = alias;
    this.type = type;
  }

  @Override
  public Context context() {
    return context;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public JoinType type() {
    return type;
  }

  @Override
  public Table on(Predicate... predicates) {
    this.joinPredicate = DSL.and(predicates);
    return this;
  }

  @Override
  public Predicate joinPredicate() {
    return joinPredicate;
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
  public Table as(String alias) {
    this.alias = () -> alias;
    return this;
  }
}
