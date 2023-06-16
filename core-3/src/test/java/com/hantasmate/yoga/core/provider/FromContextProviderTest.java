package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.FromContext;
import com.hantasmate.yoga.core.enums.JoinType;
import com.hantasmate.yoga.core.enums.OperatorType;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;
import com.hantasmate.yoga.core.provider.impl.FromContextProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromContextProviderTest {

  FromContextProvider provider;

  @BeforeEach
  void beforeEach() {
    provider = new FromContextProviderImpl(new YogaContext());
  }

  @Test
  void should_one() {
    FromContext context = provider.provide();
    TableImpl one = new TableImpl("one");
    TableImpl two = new TableImpl("two");
    TableImpl three = new TableImpl("three");
    Field sf = new FieldImpl("id", Types.INTEGER, one);
    Field tf = new FieldImpl("oid", Types.INTEGER, two);
    Field of = new FieldImpl("tid", Types.INTEGER, three);
    context.table(one);
    context.join(JoinType.INNER_JOIN, two).on(sf, OperatorType.EQ, tf);
    context.leftJoin(three).on(tf, OperatorType.EQ, of);
    assertEquals(
        provider.snippet().toString(),
        "one join two on one.id = two.oid left join three on two.oid = three.tid");
  }

  @Test
  void should_two_table_as() {
    FromContext context = provider.provide();
    Table one = new TableImpl("one").as("oo");
    Table two = new TableImpl("two").as("ot");
    Table three = new TableImpl("three").as("th");
    Field sf = new FieldImpl("id", Types.INTEGER, one);
    Field tf = new FieldImpl("oid", Types.INTEGER, two).as("oi");
    Field of = new FieldImpl("tid", Types.INTEGER, three);
    context.table(one);
    context.join(JoinType.INNER_JOIN, two).on(sf, OperatorType.EQ, tf);
    context.leftJoin(three).on(tf, OperatorType.EQ, of);
    assertEquals(
        provider.snippet().toString(),
        "one as oo join two as ot on oo.id = ot.oid left join three as th on ot.oid = th.tid");
  }
}
