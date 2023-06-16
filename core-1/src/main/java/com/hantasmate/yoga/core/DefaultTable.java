/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.Optional;

/**
 * DefaultTable
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class DefaultTable implements Table {

  private String alias;
  private final String name;

  public DefaultTable(String name) {
    this.name = name;
  }

  public DefaultTable(String name, String alias) {
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
    return Optional.ofNullable(alias).map(as -> name() + " as " + as).orElse(name());
  }

  @Override
  public String name() {
    return name;
  }
}
