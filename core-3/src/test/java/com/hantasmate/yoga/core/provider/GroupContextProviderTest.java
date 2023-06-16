package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.GroupContext;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.provider.impl.GroupContextProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupContextProviderTest {

  GroupContextProvider provider;

  @BeforeEach
  void beforeEach() {
    provider = new GroupContextProviderImpl(new YogaContext());
  }

  @Test
  void should_one() {
    GroupContext context = provider.provide();
    context.field("one");
    context.field("two");
    context.having(
        ctx -> {
          ctx.ge(new FieldImpl("id"), 1);
          ctx.eq(new FieldImpl("name"), "aaron");
        });
    assertEquals(provider.snippet().toString(), "one, two having id >= ? and name = ?");
  }
}
