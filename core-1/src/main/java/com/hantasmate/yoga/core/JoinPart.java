/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * JoinPart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface JoinPart {

  JoinOnPart join(JoinType type, String name, String alias);

  JoinOnPart join(JoinType type, Table table);

  void plainJoin(JoinType type, String name, String alias);

  void plainJoin(JoinType type, Table table);
}
