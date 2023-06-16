package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.context.OrderContext;
import com.hantasmate.yoga.core.provider.impl.OrderContextProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderContextProviderTest {

  OrderContextProvider provider;

  @BeforeEach
  void beforeEach() {
    provider = new OrderContextProviderImpl(new YogaContext());
  }

  @Test
  void should_one() {
    OrderContext context = provider.provide();
    context.desc("name");
    context.desc("age");
    assertEquals(provider.snippet().toString(), "desc name, desc age");
  }
}
