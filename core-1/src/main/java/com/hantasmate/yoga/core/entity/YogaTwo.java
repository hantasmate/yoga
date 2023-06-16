/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import com.hantasmate.yoga.core.DefaultField;
import com.hantasmate.yoga.core.DefaultTable;
import com.hantasmate.yoga.core.Field;

/**
 * YogaTwo
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class YogaTwo extends DefaultTable {

  public YogaTwo() {
    super("yoga_two");
  }

  public Field TWO_ID = new DefaultField("two_id", this);
  public Field TWO_AGE = new DefaultField("two_age", this);
  public Field TWO_GENDER = new DefaultField("two_gender", this);
  public Field TWO_NAME = new DefaultField("two_name", this);
}
