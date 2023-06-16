/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import com.hantasmate.yoga.core.DefaultField;
import com.hantasmate.yoga.core.DefaultTable;
import com.hantasmate.yoga.core.Field;

/**
 * YogaOne
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class YogaOne extends DefaultTable {

  public YogaOne() {
    super("yoga_one");
  }

  public Field ONE_ID = new DefaultField("one_id", this);
  public Field ONE_AGE = new DefaultField("one_age", this);
  public Field ONE_GENDER = new DefaultField("one_gender", this);
  public Field ONE_NAME = new DefaultField("one_name", this);
}
