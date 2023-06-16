/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.FromContext;
import com.hantasmate.yoga.core.context.JoinOnContext;
import com.hantasmate.yoga.core.enums.JoinType;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * AbstractFromContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractFromContext implements FromContext {

  protected final DslContext dslContext;
  protected final List<Table> tables;
  protected final StringBuilder snippet;
  private final StringJoiner joiner;

  protected AbstractFromContext(DslContext dslContext, Handler handler) {
    this(dslContext, handler, Priority.FROM);
  }

  protected AbstractFromContext(DslContext dslContext, Handler handler, int priority) {
    this.dslContext = dslContext;
    this.tables = new ArrayList<>();
    this.snippet = new StringBuilder();
    this.joiner = new StringJoiner(" ");
    this.dslContext.addHandler(Optional.ofNullable(handler).orElse(this::handle), priority);
  }

  @Override
  public void table(String name, String alias) {
    Table table = new TableImpl(name, alias);
    tables.add(table);
    joiner.add(Optional.ofNullable(alias).filter(as -> as.length() > 0).map(as -> name + Snippet.S_AS_S + as).orElse(name));
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

  @Override
  public JoinOnContext join(JoinType type, String name, String alias) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(name).add("as").add(alias);
    Table table = new TableImpl(joiner.toString());

    return (sf, op, tf) -> {
      StringJoiner onJoiner = new StringJoiner(" ");
      onJoiner.add(table.piece()).add("on").add(sf.piece()).add(op).add(tf.piece());
      tables.add(new TableImpl(onJoiner.toString()));
    };
  }

  @Override
  public JoinOnContext join(JoinType type, Table table) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(table.piece());
    Table nt = new TableImpl(joiner.toString());

    return (sf, op, tf) -> {
      StringJoiner onJoiner = new StringJoiner(" ");
      onJoiner.add(nt.piece()).add("on").add(sf.piece()).add(op).add(tf.piece());
      tables.add(new TableImpl(onJoiner.toString()));
    };
  }

  @Override
  public void plainJoin(JoinType type, String name, String alias) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(name).add("as").add(alias);
    Table table = new TableImpl(joiner.toString());
    this.tables.add(table);
  }

  @Override
  public void plainJoin(JoinType type, Table table) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(table.piece());
    Table nt = new TableImpl(joiner.toString());
    this.tables.add(nt);
  }

  protected void handle() {
    StringJoiner joiner = new StringJoiner(" ");
    tables.forEach(table -> joiner.add(table.piece()));
    System.out.println(snippet.append(joiner));
  }
}
