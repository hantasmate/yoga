/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

import com.hantasmate.yoga.core.enums.JoinType;

import java.util.Optional;

/**
 * Table
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Table extends Concept {

  default Context context() {
    return null;
  }

  default JoinType type() {
    return null;
  }

  default Table on(Predicate... predicates) {
    return this;
  }

  default Predicate joinPredicate() {
    return null;
  }

  default String name() {
    return null;
  }

  default String qualifiedName() {
    return Optional.ofNullable(alias()).map(Alias::name).orElse(name());
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

  default Table as(String alias) {
    return this;
  }
}
