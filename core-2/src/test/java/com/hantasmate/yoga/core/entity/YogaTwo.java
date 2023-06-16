/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;

/**
 * YogaTwo
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class YogaTwo extends TableImpl {

  public YogaTwo() {
    super("yoga_two");
  }

  public Field TWO_ID = new FieldImpl("two_id", this);
  public Field TWO_AGE = new FieldImpl("two_age", this);
  public Field TWO_GENDER = new FieldImpl("two_gender", this);
  public Field TWO_NAME = new FieldImpl("two_name", this);
}
