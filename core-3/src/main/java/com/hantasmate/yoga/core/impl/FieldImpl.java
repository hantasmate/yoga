/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.impl;

import com.hantasmate.yoga.core.Table;

/**
 * FieldImpl
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class FieldImpl extends AbstractField {

  public FieldImpl(String name) {
    super(name, false);
  }

  public FieldImpl(String name, int type) {
    super(name, type, false);
  }

  public FieldImpl(String name, boolean pure) {
    super(name, pure);
  }

  public FieldImpl(String name, int type, boolean pure) {
    super(name, type, pure);
  }

  public FieldImpl(String name, int type, Table table) {
    super(name, type, table, false);
  }

  public FieldImpl(String name, int type, Table table, boolean pure) {
    super(name, type, table, pure);
  }

  public FieldImpl(String name, String alias, int type, Table table) {
    super(name, alias, type, table, false);
  }

  public FieldImpl(String name, String alias, int type, Table table, boolean pure) {
    super(name, alias, type, table, pure);
  }
}
