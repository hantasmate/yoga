/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * DefaultFromPart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class DefaultFromPart implements FromPart {

  private final DefaultContext context;
  private final List<Table> tables;

  public DefaultFromPart(DefaultContext context) {
    this.context = context;
    this.tables = new ArrayList<>();
    FromContext fromContext = this::doContext;
    this.context.appendContext(fromContext);
  }

  @Override
  public void table(String name, String alias) {
    Table table = new DefaultTable(name, alias);
    tables.add(table);
  }

  @Override
  public void table(Table name) {
    tables.add(name);
  }

  @Override
  public void table(String... names) {
    tables.addAll(Arrays.stream(names).map(DefaultTable::new).collect(Collectors.toList()));
  }

  @Override
  public void table(Table... names) {
    tables.addAll(Arrays.stream(names).collect(Collectors.toList()));
  }

  @Override
  public void table(DefaultContext dc) {
    StringJoiner joiner = new StringJoiner(" ", "(", ")");
    Table table = new DefaultTable(joiner.add(dc.sql()).toString(), "fdsa");
    tables.add(table);
  }

  @Override
  public JoinOnPart join(JoinType type, String name, String alias) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(name).add("as").add(alias);
    Table table = new DefaultTable(joiner.toString());

    return (sf, op, tf) -> {
      StringJoiner onJoiner = new StringJoiner(" ");
      onJoiner.add(table.piece()).add("on").add(sf.piece()).add(op).add(tf.piece());
      tables.add(new DefaultTable(onJoiner.toString()));
    };
  }

  @Override
  public JoinOnPart join(JoinType type, Table table) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(table.piece());
    Table nt = new DefaultTable(joiner.toString());

    return (sf, op, tf) -> {
      StringJoiner onJoiner = new StringJoiner(" ");
      onJoiner.add(nt.piece()).add("on").add(sf.piece()).add(op).add(tf.piece());
      tables.add(new DefaultTable(onJoiner.toString()));
    };
  }

  @Override
  public void plainJoin(JoinType type, String name, String alias) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(name).add("as").add(alias);
    Table table = new DefaultTable(joiner.toString());
    this.tables.add(table);
  }

  @Override
  public void plainJoin(JoinType type, Table table) {
    StringJoiner joiner = new StringJoiner(" ");
    joiner.add(type.delimiter()).add(table.piece());
    Table nt = new DefaultTable(joiner.toString());
    this.tables.add(nt);
  }

  private void doContext() {
    System.out.println("call from part...");
    tables.forEach(
        t -> {
          System.out.println(t.piece());
        });
  }
}
