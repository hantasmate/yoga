/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;

/**
 * YogaOne
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class YogaOne extends TableImpl {

  public YogaOne() {
    super("yoga_one");
  }

  public Field ONE_ID = new FieldImpl("one_id", this);
  public Field ONE_AGE = new FieldImpl("one_age", this);
  public Field ONE_GENDER = new FieldImpl("one_gender", this);
  public Field ONE_NAME = new FieldImpl("one_name", this);
}
