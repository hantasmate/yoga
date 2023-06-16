/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.Table;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.SelectContext;
import com.hantasmate.yoga.core.enums.Keyword;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * SelectContextProvider
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public interface SelectContextProvider extends FieldContextProvider<SelectContext>, SelectContext {

  @Override
  default SelectContext provide() {
    return this;
  }

  @Override
  default void hint(Keyword keyword) {
    Runnable task =
        () -> {
          snippet().insert(0, keyword.keyword() + Snippet.SPACE);

          // if (snippet().length() == 0) {
          //   snippet().append(keyword.keyword());
          //   return;
          // }
          // snippet().append(Snippet.SPACE).append(keyword.keyword());
        };
    tasks().add(task);
  }

  @Override
  default void asterisk(Table table) {
    List<Field> fields = table.fields();
    field(
        Optional.ofNullable(fields)
            .filter(ls -> ls.size() > 0)
            .orElse(Collections.emptyList())
            .toArray(new Field[0]));
  }

  @Override
  default void asterisk() {
    field(Snippet.ASTERISK);
  }
}
