/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Context;
import com.hantasmate.yoga.core.Field;

/**
 * FieldContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public interface FieldContext extends Context {

  void field(String name, String alias);

  void field(Field name);

  void field(String... names);

  void field(Field... names);
}
