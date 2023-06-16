/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Helper
 *
 * @author tabuyos
 * @since 2023/3/13
 */
public class HelperMain {

  @FunctionalInterface
  interface Helper {
    void select(A consumer);
  }

  static class ContextHelper extends DSLC implements Helper {
    @Override
    public void select(A consumer) {
      // consumer.accept(this);
    }
  }

  @FunctionalInterface
  interface A {
    void a();
    default void b() {
      a();
    };
  }

  static class DSLC {
    private void and(String name) {
      System.out.println(name);
    }
  }

  public static void main(String[] args) {
    ContextHelper helper = new ContextHelper();
    helper.select(() -> {
      // this.b();
    });
  }
}
