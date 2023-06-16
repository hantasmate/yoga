/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import com.hantasmate.yoga.core.entity.YogaOne;
import com.hantasmate.yoga.core.entity.YogaThree;
import com.hantasmate.yoga.core.entity.YogaTwo;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * HelperMain
 *
 * @author tabuyos
 * @since 2023/3/14
 */
public class HelperMain {

  /**
   *
   *
   * <pre>{@code
   * Helper.create().select(ctx -> {
   *   ctx.field(a.id);
   *   ctx.field(a.age);
   *   ctx.field(a.name);
   *   ctx.field(a.gender);
   *   ctx.field(b.name);
   *   ctx.field(c.lesson);
   * }).from((ctx) -> {
   *   ctx.table("a");
   *   ctx.join("b").on("a.id", "=", "b.aid");
   *   ctx.join("c").on("a.id", "=", "c.aid");
   *   ctx.join("(select aid from d) as t").on("a.id", "=", "t.aid");
   * }).where((ctx) -> {
   *   ctx.eq(a.id, 1);
   *   ctx.eq(a.deleted, 0);
   *   ctx.or(ctx.eq(a.status, 1));
   *   ctx.and(a.pi, 3);
   * }).groupBy((ctx) -> {
   *   ctx.field(a.name);
   *   ctx.having((cth) -> {
   *     // cth.eq(cth.fun("count(*)"), 1);
   *     cth.eq(cth.count(), 1);
   *   });
   * }).orderBy((ctx) -> {
   *   ctx.desc(a.age);
   *   ctx.desc(a.name);
   * })
   * // .sql()
   * // .bindValues()
   * .execution();
   * }</pre>
   *
   * @param args main args
   */
  public static void main(String[] args) throws SQLException {
    YogaOne one = new YogaOne();
    YogaTwo two = new YogaTwo();
    YogaThree three = new YogaThree();
    one.as("mo");
    two.as("no");
    three.as("ko");
    Helper.create()
        .select(
            ctx -> {
              ctx.field(one.ONE_AGE, one.ONE_GENDER, two.TWO_ID);
              ctx.field(one.ONE_NAME);
            })
        .from(
            ctx -> {
              ctx.table(one);
              ctx.plainJoin(JoinType.INNER_JOIN, two);
              ctx.join(JoinType.INNER_JOIN, three).on(one.ONE_ID, "=", three.THREE_ID);
            })
        .where(
            ctx -> {
              ctx.eq(one.ONE_NAME, "张三");
              ctx.eq(one.ONE_AGE, 22);
              ctx.or(
                  () -> {
                    ctx.eq(one.ONE_GENDER, 0);
                    ctx.eq(one.ONE_ID, 101);
                  });
              ctx.eq(two.TWO_AGE, 24);
            })
        .groupBy(
            ctx -> {
              ctx.field(one.ONE_NAME);
              ctx.field(one.ONE_AGE);
              ctx.having((cth) -> {
                cth.eq(one.ONE_NAME, "张三");
              });
            })
      .orderBy(ctx -> {
      })
        .execution();
  }
}
