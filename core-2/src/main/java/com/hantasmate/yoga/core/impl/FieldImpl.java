/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.impl;

import com.hantasmate.yoga.core.AbstractField;
import com.hantasmate.yoga.core.Table;

/**
 * FieldImpl
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class FieldImpl extends AbstractField {

  public FieldImpl(String name) {
    super(name);
  }

  public FieldImpl(String name, Table table) {
    super(name, table);
  }

  public FieldImpl(String name, String alias, Table table) {
    super(name, alias, table);
  }
}
