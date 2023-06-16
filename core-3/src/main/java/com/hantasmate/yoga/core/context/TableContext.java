/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.YogaContext;

/**
 * TableContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public interface TableContext extends Context {
  void table(String name, String alias);

  void table(Table table);

  void table(String... names);

  void table(Table... tables);

  void table(YogaContext yc);

  void table(YogaContext yc, String alias);
}
