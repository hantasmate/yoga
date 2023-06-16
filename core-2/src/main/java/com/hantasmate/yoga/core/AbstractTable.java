/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import com.hantasmate.yoga.core.contant.Snippet;

import java.util.Optional;

/**
 * AbstractTable
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public abstract class AbstractTable implements Table {

  private String alias;
  private final String name;

  public AbstractTable(String name) {
    this.name = name;
  }

  public AbstractTable(String name, String alias) {
    this.name = name;
    this.alias = alias;
  }

  @Override
  public Table as(String as) {
    this.alias = as;
    return this;
  }

  @Override
  public String as() {
    return alias;
  }

  @Override
  public String piece() {
    return Optional.ofNullable(alias)
        .map(as -> name() + Snippet.SPACE + Snippet.AS + Snippet.SPACE + as)
        .orElse(name());
  }

  @Override
  public String name() {
    return name;
  }
}
