/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.tuple;

/**
 * TwoTuple
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class TwoTuple<ONE, TWO> extends OneTuple<ONE> {

  private TWO two;

  public TwoTuple() {}

  private TwoTuple(ONE one, TWO two) {
    this.one(one);
    this.two = two;
  }

  public static <ONE, TWO> TwoTuple<ONE, TWO> of(ONE one, TWO two) {
    return new TwoTuple<>(one, two);
  }

  public TWO two() {
    return two;
  }

  public void two(TWO two) {
    this.two = two;
  }
}
