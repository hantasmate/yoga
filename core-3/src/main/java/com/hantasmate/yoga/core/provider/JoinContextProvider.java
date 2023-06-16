/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.JoinContext;
import com.hantasmate.yoga.core.context.JoinOnContext;
import com.hantasmate.yoga.core.enums.JoinType;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.util.StringJoiner;

/**
 * JoinContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface JoinContextProvider<T>
    extends ContextProvider<T, YogaContext, StringBuilder>, JoinContext {

  @Override
  default JoinOnContext join(JoinType type, String name, String alias) {
    context().tables().add(new TableImpl(name, alias));
    StringJoiner joinJoiner = new StringJoiner(Snippet.SPACE);
    joinJoiner.add(type.delimiter()).add(name).add(Snippet.AS).add(alias);

    return (sf, op, tf) -> {
      StringJoiner onJoiner = new StringJoiner(" ");
      onJoiner
          .add(joinJoiner.toString())
          .add(Snippet.ON)
          .add(sf.qualifiedName())
          .add(op.operator())
          .add(tf.qualifiedName());
      doClosure(onJoiner.toString());
    };
  }

  @Override
  default JoinOnContext join(JoinType type, Table table) {
    context().tables().add(table);
    StringJoiner joinJoiner = new StringJoiner(Snippet.SPACE);
    joinJoiner.add(type.delimiter()).add(table.segment());

    return (sf, op, tf) -> {
      StringJoiner onJoiner = new StringJoiner(Snippet.SPACE);
      onJoiner
          .add(joinJoiner.toString())
          .add(Snippet.ON)
          .add(sf.qualifiedName())
          .add(op.operator())
          .add(tf.qualifiedName());
      doClosure(onJoiner.toString());
    };
  }

  @Override
  default void plainJoin(JoinType type, String name, String alias) {
    context().tables().add(new TableImpl(name, alias));
    StringJoiner joinJoiner = new StringJoiner(Snippet.SPACE);
    joinJoiner.add(type.delimiter()).add(name).add(Snippet.AS).add(alias);
    doClosure(joinJoiner.toString());
  }

  @Override
  default void plainJoin(JoinType type, Table table) {
    context().tables().add(table);
    StringJoiner joinJoiner = new StringJoiner(Snippet.SPACE);
    joinJoiner.add(type.delimiter()).add(table.segment());
    doClosure(joinJoiner.toString());
  }
}
