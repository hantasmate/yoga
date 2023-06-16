/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * Join
 * a.join(left, b).on(af.id, op, bf.aid)
 * a join b on a.id = b.aid
 *   join c on a.id = c.aid
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface Join extends On {

  Table join(JoinType type, Table joinTable);
}
