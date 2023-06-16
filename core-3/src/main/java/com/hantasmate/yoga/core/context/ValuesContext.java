/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * ValuesContext
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public interface ValuesContext extends Context {

  <E> void values(E entity);
  <E> void values(Collection<E> entities);
  void values(Object... values);

  void values(Supplier<?>... suppliers);
}
