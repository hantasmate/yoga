package com.hantasmate.yoga.core.helper;

import com.hantasmate.yoga.core.entity.YogaOne;
import com.hantasmate.yoga.core.entity.YogaThree;
import com.hantasmate.yoga.core.entity.YogaTwo;
import com.hantasmate.yoga.core.enums.JoinType;
import com.hantasmate.yoga.core.enums.OperatorType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DqlHelperTest {

  @Test
  void select() {
    YogaOne one = new YogaOne();
    YogaTwo two = new YogaTwo();
    YogaThree three = new YogaThree();

    DqlHelper.create()
        .select(
            ctx -> {
              ctx.field(one.ONE_ID.as("asd"));
              ctx.field(one.ONE_AGE);
            })
        .execution();
  }

  @Test
  void from() {
    YogaOne one = new YogaOne();
    YogaTwo two = new YogaTwo();
    YogaThree three = new YogaThree();

    DqlHelper.create()
        .select(
            ctx -> {
              ctx.field(one.ONE_ID);
              ctx.field(one.ONE_AGE);
            })
        .from(
            ctx -> {
              ctx.table(one);
              ctx.join(JoinType.INNER_JOIN, two)
                  .on(one.ONE_ID, OperatorType.EQ.operator(), two.TWO_ID);
            })
        .execution();
  }

  @Test
  void where() {
    YogaOne one = new YogaOne();
    YogaTwo two = new YogaTwo();
    YogaThree three = new YogaThree();

    DqlHelper.create()
        .select(
            ctx -> {
              ctx.field(one.ONE_ID);
              ctx.field(one.ONE_AGE);
            })
        .from(
            ctx -> {
              ctx.table(one);
              ctx.join(JoinType.INNER_JOIN, two)
                  .on(one.ONE_ID, OperatorType.EQ.operator(), two.TWO_ID);
            })
        .where(
            ctx -> {
              ctx.eq(one.ONE_AGE, 23);
              ctx.eq(one.ONE_NAME, "aaron");
            })
        .execution();
  }

  @Test
  void group() {
    YogaOne one = new YogaOne();
    YogaTwo two = new YogaTwo();
    YogaThree three = new YogaThree();

    DqlHelper.create()
        .select(
            ctx -> {
              ctx.field(one.ONE_ID);
              ctx.field(one.ONE_AGE);
            })
        .from(
            ctx -> {
              ctx.table(one);
              ctx.join(JoinType.INNER_JOIN, two)
                  .on(one.ONE_ID, OperatorType.EQ.operator(), two.TWO_ID);
            })
        .where(
            ctx -> {
              ctx.eq(one.ONE_AGE, 23);
              ctx.eq(one.ONE_NAME, "aaron");
            })
        .groupBy(
            ctx -> {
              ctx.field(one.ONE_GENDER);
              ctx.field(one.ONE_NAME);
            })
        .execution();
  }
}
