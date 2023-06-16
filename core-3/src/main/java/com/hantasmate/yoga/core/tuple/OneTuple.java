/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.tuple;

import com.hantasmate.yoga.core.Tuple;

/**
 * OneTuple
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class OneTuple<ONE> implements Tuple {

  private ONE one;

  public OneTuple() {
  }

  private OneTuple(ONE one) {
    this.one = one;
  }

  public static <ONE> OneTuple<ONE> of(ONE one) {
    return new OneTuple<>(one);
  }

  public ONE one() {
    return one;
  }

  public void one(ONE one) {
    this.one = one;
  }
}
