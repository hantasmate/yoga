package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.SelectContext;
import com.hantasmate.yoga.core.enums.Keyword;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;
import com.hantasmate.yoga.core.provider.impl.SelectContextProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectContextProviderTest {

  SelectContextProvider provider;

  @BeforeEach
  void beforeEach() {
    provider = new SelectContextProviderImpl(new YogaContext());
  }

  @Test
  void should_one() {
    SelectContext context = provider.provide();
    context.field("one");
    context.field("two");
    assertEquals(provider.snippet().toString(), "one, two");
  }

  @Test
  void should_two() {
    Table one = new TableImpl("one").as("oo");
    Table two = new TableImpl("two").as("ot");
    Table three = new TableImpl("three").as("th");
    Field sf = new FieldImpl("id", Types.INTEGER, one);
    Field tf = new FieldImpl("oid", Types.INTEGER, two).as("oi");
    Field of = new FieldImpl("tid", Types.INTEGER, three);
    SelectContext context = provider.provide();
    context.field(sf);
    context.field(tf);
    context.field(of);
    assertEquals(provider.snippet().toString(), "oo.id, ot.oid as oi, th.tid");
  }

  @Test
  void should_three() {
    SelectContext context = provider.provide();
    context.hint(Keyword.DISTINCT);
    context.field("one");
    context.field("two");
    provider.handle();
    assertEquals(provider.snippet().toString(), "distinct one, two");
  }
}
