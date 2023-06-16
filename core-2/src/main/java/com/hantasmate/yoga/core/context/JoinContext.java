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
public interface JoinContext {

  JoinOnContext join(JoinType type, String name, String alias);

  JoinOnContext join(JoinType type, Table table);

  void plainJoin(JoinType type, String name, String alias);

  void plainJoin(JoinType type, Table table);
}
