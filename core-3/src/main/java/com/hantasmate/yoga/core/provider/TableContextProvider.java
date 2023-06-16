/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.TableContext;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.util.Arrays;

/**
 * TableContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface TableContextProvider<T>
    extends ContextProvider<T, YogaContext, StringBuilder>, TableContext {

  @Override
  default void table(String name, String alias) {
    Table table = new TableImpl(name, alias);
    context().tables().add(table);
    doClosure(table.segment());
  }

  @Override
  default void table(Table table) {
    context().tables().add(table);
    doClosure(table.segment());
  }

  @Override
  default void table(String... names) {
    Arrays.stream(names)
        .map(TableImpl::new)
        .peek(context().tables()::add)
        .map(Table::segment)
        .forEach(this::doClosure);
  }

  @Override
  default void table(Table... tables) {
    Arrays.stream(tables)
        .peek(context().tables()::add)
        .map(Table::segment)
        .forEach(this::doClosure);
  }

  @Override
  default void table(YogaContext yc) {
    Table table = new TableImpl(yc.plainSql());
    context().tables().add(table);
    doClosure(table.segment());
  }

  @Override
  default void table(YogaContext yc, String alias) {
    Table table = new TableImpl(yc.plainSql(), alias);
    context().tables().add(table);
    doClosure(table.segment());
  }

  @Override
  default void plain(String segment) {
    doClosure(segment);
  }
}
