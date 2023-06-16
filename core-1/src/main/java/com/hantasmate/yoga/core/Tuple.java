/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.StringJoiner;

/**
 * Tuple
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class Tuple<ONE, TWO> {

  private ONE one;
  private TWO two;

  private Tuple(ONE one, TWO two) {
    this.one = one;
    this.two = two;
  }

  public static <ONE, TWO> Tuple<ONE, TWO> of(ONE one, TWO two) {
    return new Tuple<>(one, two);
  }

  public ONE one() {
    return one;
  }

  public void one(ONE one) {
    this.one = one;
  }

  public TWO two() {
    return two;
  }

  public void two(TWO two) {
    this.two = two;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Tuple.class.getSimpleName() + "(", ")")
      .add("one=" + one)
      .add("two=" + two)
      .toString();
  }
}
