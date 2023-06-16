/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Context;
import com.hantasmate.yoga.core.Field;

/**
 * OrderContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public interface OrderContext extends Context {

  void desc(String name);

  void desc(Field name);

  void asc(String name);

  void asc(Field name);
}
