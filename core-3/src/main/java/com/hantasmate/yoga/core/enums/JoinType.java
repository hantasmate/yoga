/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.enums;

/**
 * JoinType
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public enum JoinType {
  /**
   * 内连接, 可省略 inner
   */
  INNER_JOIN("join"),
  /**
   * 笛卡尔连接, 可全省略, 使用逗号连接
   *
   * <p>在 mysql 中 join(省略了 inner), inner join 以及 cross join 等价
   */
  CROSS_JOIN(","),
  /**
   * 左外连接
   */
  LEFT_JOIN("left join"),
  /**
   * 右外连接
   */
  RIGHT_JOIN("right join"),
  /**
   * 全外连接
   */
  FULL_JOIN("full join");

  private final String delimiter;

  JoinType(String delimiter) {
    this.delimiter = delimiter;
  }

  public String delimiter() {
    return delimiter;
  }
}
