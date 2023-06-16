/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.pair;

import com.hantasmate.yoga.core.Pair;

import java.sql.Types;
import java.util.StringJoiner;

/**
 * BindPair
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class BindPair implements Pair {

  private final int type;
  private final Object value;

  private BindPair(Object value, int type) {
    this.value = value;
    this.type = type;
  }

  public static BindPair of(Object value) {
    return new BindPair(value, Types.VARCHAR);
  }

  public static BindPair of(Object value, int type) {
    return new BindPair(value, type);
  }

  public int type() {
    return type;
  }

  public Object value() {
    return value;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BindPair.class.getSimpleName() + "(", ")")
        .add("type=" + type)
        .add("value=" + value)
        .toString();
  }
}
