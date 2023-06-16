/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.impl;

/**
 * TableImpl
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class TableImpl extends AbstractTable {

  public TableImpl(String name) {
    super(name);
  }
  public TableImpl(String name, boolean pure) {
    super(name, pure);
  }
  public TableImpl(String name, String alias) {
    super(name, alias, false);
  }
  public TableImpl(String name, String alias, boolean pure) {
    super(name, alias, pure);
  }
}
