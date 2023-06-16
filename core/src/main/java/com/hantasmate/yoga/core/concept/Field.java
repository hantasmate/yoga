/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

import java.util.Optional;

/**
 * Field
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Field extends Concept {

  default String name() {
    return null;
  }
  default String qualifiedName() {
    return Optional.ofNullable(table())
      .map(Table::name)
      .map(tableName -> table().alias() == null ? tableName : table().alias().name())
      .map(tas -> tas + "." + name())
      .orElse(name());
  }
  default Table table() {
    return null;
  }
  default Schema schema() {
    return null;
  }
  default Database database() {
    return null;
  }

  default Alias alias() {
    return null;
  }
  default Field as(String alias) {
    return this;
  }
}
