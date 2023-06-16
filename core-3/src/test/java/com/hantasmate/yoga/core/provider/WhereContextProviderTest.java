package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.WhereContext;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.provider.impl.WhereContextProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhereContextProviderTest {

  WhereContextProvider provider;

  @BeforeEach
  void beforeEach() {
    provider = new WhereContextProviderImpl(new YogaContext());
  }

  @Test
  void should_eq() {
    WhereContext context = provider.provide();
    context.eq(new FieldImpl("id", Types.INTEGER), 123);
    assertEquals(provider.snippet().toString(), "id = ?");
    assertEquals(provider.context().bindValues().size(), 1);
    assertEquals(provider.context().bindValues().get(0).type(), 4);
    assertEquals(provider.context().bindValues().get(0).value(), 123);
  }

  @Test
  void should_ne() {
    WhereContext context = provider.provide();
    context.ne(new FieldImpl("id", Types.INTEGER), 123);
    assertEquals(provider.snippet().toString(), "id <> ?");
    assertEquals(provider.context().bindValues().size(), 1);
    assertEquals(provider.context().bindValues().get(0).type(), 4);
    assertEquals(provider.context().bindValues().get(0).value(), 123);
  }

  @Test
  void should_2_eq() {
    WhereContext context = provider.provide();
    context.eq(new FieldImpl("id", Types.INTEGER), 123);
    context.eq(new FieldImpl("name", Types.VARCHAR), "tabuyos");
    // context.or(() -> {
    //   context.eq(new FieldImpl("nick", Types.VARCHAR), "tf");
    //   context.eq(new FieldImpl("age", Types.INTEGER), 23);
    // });
    assertEquals(provider.snippet().toString(), "id = ? and name = ?");
    assertEquals(provider.context().bindValues().size(), 2);
  }

  @Test
  void should_2_eq_or() {
    WhereContext context = provider.provide();
    context.eq(new FieldImpl("id", Types.INTEGER), 123);
    context.eq(new FieldImpl("name", Types.VARCHAR), "tabuyos");
    context.or(
        () -> {
          context.eq(new FieldImpl("nick", Types.VARCHAR), "tf");
          context.eq(new FieldImpl("age", Types.INTEGER), 23);
        });
    context.isNull(new FieldImpl("master", Types.INTEGER));
    assertEquals(
        provider.snippet().toString(),
        "id = ? and name = ? or (nick = ? and age = ?) and master is null");
    assertEquals(provider.context().bindValues().size(), 4);
  }

  @Test
  void should_2_eq_or_and() {
    WhereContext context = provider.provide();
    context.eq(new FieldImpl("id", Types.INTEGER), 123);
    context.or(
        () -> {
          context.eq(new FieldImpl("nick", Types.VARCHAR), "tf");
          context.and(() -> context.eq(new FieldImpl("tel", Types.VARCHAR), "0000-123-122"));
          context.eq(new FieldImpl("age", Types.INTEGER), 23);
        });
    context.isNull(new FieldImpl("master", Types.INTEGER));
    context.eq(new FieldImpl("deleted", Types.INTEGER), 1);
    assertEquals(
        provider.snippet().toString(),
        "id = ? or (nick = ? and (tel = ?) and age = ?) and master is null and deleted = ?");
    assertEquals(provider.context().bindValues().size(), 5);
  }

  @Test
  void should_2_and() {
    WhereContext context = provider.provide();
    context.and(
        () -> {
          context.eq(new FieldImpl("id", Types.INTEGER), 123);
          context.eq(new FieldImpl("nick", Types.VARCHAR), "tf");
          context.eq(new FieldImpl("age", Types.INTEGER), 23);
        });
    context.or(() -> context.eq(new FieldImpl("tel", Types.VARCHAR), "0000-123-122"));
    assertEquals(provider.snippet().toString(), "(id = ? and nick = ? and age = ?) or (tel = ?)");
    assertEquals(provider.context().bindValues().size(), 4);
  }
}
