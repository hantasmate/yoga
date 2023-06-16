package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.InsertIntoContext;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;
import com.hantasmate.yoga.core.provider.impl.InsertIntoContextProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertIntoContextProviderTest {

  InsertIntoContextProvider provider;

  @BeforeEach
  void beforeEach() {
    provider = new InsertIntoContextProviderImpl(new YogaContext());
  }

  @Test
  void should_one() {
    TableImpl one = new TableImpl("one");
    InsertIntoContext context = provider.provide();
    context.into(one);
    assertEquals(provider.snippet().toString(), "one");
    provider.handle();
    assertEquals(provider.context().sqlBuilder().toString(), "insert into one");
  }

  @Test
  void should_two() {
    TableImpl one = new TableImpl("one");
    Field sf = new FieldImpl("id", Types.INTEGER, one);
    InsertIntoContext context = provider.provide();
    context.into(one, sf);
    assertEquals(provider.snippet().toString(), "one(id)");
    assertEquals(provider.context().sqlBuilder().toString(), "insert into one(id)");
  }

  @Test
  void should_three() {
    TableImpl one = new TableImpl("one");
    Field sf = new FieldImpl("id", Types.INTEGER, one);
    Field of = new FieldImpl("name", Types.INTEGER, one);
    InsertIntoContext context = provider.provide();
    context.into(one, sf, of);
    assertEquals(provider.snippet().toString(), "one(id, name)");
    provider.handle();
    assertEquals(provider.context().sqlBuilder().toString(), "insert into one(id, name)");
  }
}
