/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import com.hantasmate.yoga.core.DefaultField;
import com.hantasmate.yoga.core.DefaultTable;
import com.hantasmate.yoga.core.Field;

/**
 * YogaThree
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class YogaThree extends DefaultTable {

  public YogaThree() {
    super("yoga_three");
  }

  public Field THREE_ID = new DefaultField("three_id", this);
  public Field THREE_AGE = new DefaultField("three_age", this);
  public Field THREE_GENDER = new DefaultField("three_gender", this);
  public Field THREE_NAME = new DefaultField("three_name", this);
}
