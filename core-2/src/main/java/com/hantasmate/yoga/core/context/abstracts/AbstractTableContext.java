/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.TableContext;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * AbstractTableContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractTableContext implements TableContext {

  protected final DslContext dslContext;
  protected final List<Table> tables;

  protected AbstractTableContext(DslContext dslContext, Handler handler) {
    this(dslContext, handler, Priority.FROM);
  }

  protected AbstractTableContext(DslContext dslContext, Handler handler, int priority) {
    this.dslContext = dslContext;
    this.tables = new ArrayList<>();
    this.dslContext.addHandler(Optional.ofNullable(handler).orElse(this::handle), priority);
  }

  @Override
  public void table(String name, String alias) {
    Table table = new TableImpl(name, alias);
    tables.add(table);
  }

  @Override
  public void table(Table name) {
    tables.add(name);
  }

  @Override
  public void table(String... names) {
    tables.addAll(Arrays.stream(names).map(TableImpl::new).collect(Collectors.toList()));
  }

  @Override
  public void table(Table... names) {
    tables.addAll(Arrays.stream(names).collect(Collectors.toList()));
  }

  @Override
  public void table(DslContext dc) {
    table(dc, "" + dc.hashCode());
  }

  @Override
  public void table(DslContext dc, String alias) {
    StringJoiner joiner = new StringJoiner(" ", "(", ")");
    Table table = new TableImpl(joiner.add(dc.pureSql()).toString(), alias);
    tables.add(table);
  }

  protected void handle() {}
}
