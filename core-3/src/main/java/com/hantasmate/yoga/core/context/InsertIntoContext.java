/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;

/**
 * InsertIntoContext
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public interface InsertIntoContext extends Context {

  void into(Table table);
  void into(Table table, Field... fields);
}
