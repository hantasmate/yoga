/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.contant;

/**
 * Priority
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class Priority {

  public static final int DEFAULT = Integer.MAX_VALUE;
  /**
   * priority of select
   */
  public static final int SELECT = 0;
  /**
   * priority of from
   */
  public static final int FROM = 1000;
  /**
   * priority of where
   */
  public static final int WHERE = 2000;
  /**
   * priority of group by
   */
  public static final int GROUP_BY = 3000;
  /**
   * priority of order by
   */
  public static final int ORDER_BY = 4000;
}
