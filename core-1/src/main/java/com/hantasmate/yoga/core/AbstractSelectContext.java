/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

/**
 * AbstractSelectContext
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public abstract class AbstractSelectContext implements SelectContext {

  protected String names = "";

  @Override
  public void field(String name) {
    names += " " + name;
  }

  @Override
  public void doContext() {
    System.out.println(">" + names);
  }
}
