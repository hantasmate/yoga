/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.impl.TableImpl;

import static com.hantasmate.yoga.core.DSL.field;

/**
 * UserInfo
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class UserInfo extends TableImpl {

  @Override
  public String name() {
    return "user";
  }

  public final Field ID = field("id", this);
  public final Field NAME = field("name", this);
  public final Field AGE = field("age", this);
}
