package com.hantasmate.yoga.core.helper;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;
import com.hantasmate.yoga.core.interceptor.WhereContextInterceptorTest;
import com.hantasmate.yoga.core.pair.BindPair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Types;

class DqlHelperTest {

  DqlHelper helper;

  @BeforeEach
  void beforeEach() {
    helper = DqlHelper.create();
  }

  @Test
  void should_one() {
    helper.context().addInterceptor(new WhereContextInterceptorTest());
    helper.context().prepareContext();
  }

  @Test
  void should_two() {
    Table one = new TableImpl("one").as("oo");
    Table two = new TableImpl("two").as("ot");
    Table three = new TableImpl("three").as("th");
    Field sf = new FieldImpl("id", Types.INTEGER, one);
    Field tf = new FieldImpl("oid", Types.INTEGER, two).as("oi");
    Field of = new FieldImpl("tid", Types.INTEGER, three);
    helper.context().addInterceptor(new WhereContextInterceptorTest());
    helper
        .select(
            ctx -> {
              ctx.field(sf);
              ctx.field(tf);
              ctx.distinct();
            })
        .from(
            ctx -> {
              ctx.table(one);
            })
        .where(
            ctx -> {
              ctx.eq(sf, 1);
            })
        .orderBy(ctx -> ctx.desc(of))
        .execution();
  }

  @Test
  void should_three() {
    helper.plainSql("select * from abc where id = ?", BindPair.of(23, Types.INTEGER)).execution();
  }
}
