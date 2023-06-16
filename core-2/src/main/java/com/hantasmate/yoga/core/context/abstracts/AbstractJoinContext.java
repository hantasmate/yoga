/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context.abstracts;

import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.JoinContext;
import com.hantasmate.yoga.core.context.JoinOnContext;
import com.hantasmate.yoga.core.enums.JoinType;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * AbstractJoinContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractJoinContext implements JoinContext {

  protected final DslContext dslContext;
  protected final List<Table> tables;

  protected AbstractJoinContext(DslContext dslContext, Handler handler) {
    this(dslContext, handler, Priority.FROM);
  }

  protected AbstractJoinContext(DslContext dslContext, Handler handler, int priority) {
    this.dslContext = dslContext;
    this.tables = new ArrayList<>();
    this.dslContext.addHandler(Optional.ofNullable(handler).orElse(this::handle), priority);
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

  }
}
