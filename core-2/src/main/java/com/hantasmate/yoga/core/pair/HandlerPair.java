/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.pair;

import com.hantasmate.yoga.core.Handler;
import com.hantasmate.yoga.core.Pair;

/**
 * HandlerPair
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class HandlerPair implements Pair {

  /**
   * 优先级
   */
  private final Integer priority;
  /**
   * 处理器
   */
  private final Handler handler;

  private HandlerPair(Integer priority, Handler handler) {
    this.priority = priority;
    this.handler = handler;
  }

  public static HandlerPair of(Integer priority, Handler handler) {
    return new HandlerPair(priority, handler);
  }

  public Integer priority() {
    return priority;
  }

  public Handler handler() {
    return handler;
  }
}
