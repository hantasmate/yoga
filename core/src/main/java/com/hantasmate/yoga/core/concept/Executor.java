/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

import java.util.Optional;

/**
 * Executor
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Executor extends Concept, ContextProvider {

  default void execute() {
    Context context = Optional.ofNullable(context()).orElseThrow(() -> new NullPointerException("Context must be non-null"));
    System.out.println(context.hashCode());
    System.out.println(context.parts().size());
    context.parts().forEach(System.out::println);
    context.parts().forEach(field -> System.out.println(field.name()));
    context.process();
    System.out.println(context.sql());
  }
}
