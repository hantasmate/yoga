/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;

/**
 * YogaThree
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class YogaThree extends TableImpl {

  public YogaThree() {
    super("yoga_three");
  }

  public Field THREE_ID = new FieldImpl("three_id", this);
  public Field THREE_AGE = new FieldImpl("three_age", this);
  public Field THREE_GENDER = new FieldImpl("three_gender", this);
  public Field THREE_NAME = new FieldImpl("three_name", this);
}
