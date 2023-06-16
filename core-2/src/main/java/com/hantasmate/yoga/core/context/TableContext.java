/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Context;
import com.hantasmate.yoga.core.DslContext;
import com.hantasmate.yoga.core.Table;

/**
 * TableContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public interface TableContext extends Context {
  void table(String name, String alias);

  void table(Table name);

  void table(String... names);

  void table(Table... names);

  void table(DslContext dc);

  void table(DslContext dc, String alias);
}
