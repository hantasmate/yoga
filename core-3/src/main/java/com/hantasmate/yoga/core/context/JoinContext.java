/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.enums.JoinType;

/**
 * JoinContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public interface JoinContext extends Context {

  JoinOnContext join(JoinType type, String name, String alias);

  JoinOnContext join(JoinType type, Table table);

  default JoinOnContext leftJoin(Table table) {
    return this.join(JoinType.LEFT_JOIN, table);
  }

  default JoinOnContext rightJoin(Table table) {
    return this.join(JoinType.RIGHT_JOIN, table);
  }

  void plainJoin(JoinType type, String name, String alias);

  void plainJoin(JoinType type, Table table);

  default void plainJoin(Table table) {
    plainJoin(JoinType.CROSS_JOIN, table);
  }
}
