/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.enums.Keyword;

/**
 * SelectContext
 *
 * @author tabuyos
 * @since 2023/3/17
 */
public interface SelectContext extends FieldContext {

  void hint(Keyword keyword);

  default void distinct() {
    hint(Keyword.DISTINCT);
  }

  void asterisk(Table table);

  void asterisk();
}
