package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.ValuesContext;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;
import com.hantasmate.yoga.core.provider.impl.ValuesContextProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValuesContextProviderTest {

  ValuesContextProvider provider;

  @BeforeEach
  void beforeEach() {
    provider = new ValuesContextProviderImpl(new YogaContext());
  }

  @Test
  void should_one() {
    TableImpl one = new TableImpl("one");
    Field id = new FieldImpl("id", Types.INTEGER, one);
    Field name = new FieldImpl("name", Types.INTEGER, one);
    Field age = new FieldImpl("age", Types.INTEGER, one);
    ValuesContext context = provider.provide();
    provider.context().fields().addAll(Arrays.asList(id, name, age));
    context.values(1, 22, 333);
    assertEquals(provider.snippet().toString(), "(?, ?, ?)");
    assertEquals(provider.context().bindValues().size(), 3);
    assertEquals(provider.context().bindValues().get(2).value(), 333);
  }

  @Test
  void should_two() {
    TableImpl one = new TableImpl("one");
    Field id = new FieldImpl("id", Types.INTEGER, one);
    Field name = new FieldImpl("name", Types.INTEGER, one);
    Field age = new FieldImpl("age", Types.INTEGER, one);
    ValuesContext context = provider.provide();
    provider.context().fields().addAll(Arrays.asList(id, name, age));
    context.values(1, 2, 3);
    context.values(11, 22, 33);
    assertEquals(provider.snippet().toString(), "(?, ?, ?), (?, ?, ?)");
    assertEquals(provider.context().bindValues().size(), 6);
    assertEquals(provider.context().bindValues().get(4).value(), 22);
  }

  @Test
  void should_three() {
    TableImpl one = new TableImpl("one");
    Field id = new FieldImpl("id", Types.INTEGER, one);
    Field name = new FieldImpl("name", Types.INTEGER, one);
    Field age = new FieldImpl("age", Types.INTEGER, one);
    ValuesContext context = provider.provide();
    provider.context().fields().addAll(Arrays.asList(id, name, age));
    Entity entity = new Entity();
    entity.setId(10001);
    entity.setName(2000);
    entity.setAge(23);
    context.values(entity);
    assertEquals(provider.snippet().toString(), "(?, ?, ?)");
    assertEquals(provider.context().bindValues().size(), 3);
    assertEquals(provider.context().bindValues().get(1).value(), 2000);
  }

  @Test
  void should_four() {
    TableImpl one = new TableImpl("one");
    Field id = new FieldImpl("id", Types.INTEGER, one);
    Field name = new FieldImpl("name", Types.INTEGER, one);
    Field age = new FieldImpl("age", Types.INTEGER, one);
    Field userId = new FieldImpl("user_id", Types.INTEGER, one);
    ValuesContext context = provider.provide();
    provider.context().fields().addAll(Arrays.asList(id, age, name, userId));
    Entity entity = new Entity();
    entity.setId(10001);
    entity.setName(2000);
    entity.setAge(23);
    entity.setUserId(20002);
    context.values(entity);
    assertEquals(provider.snippet().toString(), "(?, ?, ?, ?)");
    assertEquals(provider.context().bindValues().size(), 4);
    assertEquals(provider.context().bindValues().get(3).value(), 20002);
  }

  static class Entity {
    private Integer id;
    private Integer name;
    private Integer age;
    private Integer userId;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public Integer getName() {
      return name;
    }

    public void setName(Integer name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    public Integer getUserId() {
      return userId;
    }

    public void setUserId(Integer userId) {
      this.userId = userId;
    }
  }
}
