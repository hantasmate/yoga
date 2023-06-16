/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.generator;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;

/**
 * Metadata
 *
 * @author tabuyos
 * @since 2023/3/20
 */
public class Metadata extends TableImpl {

  public Metadata() {
    super("yoga", true);
  }

  public final Field id = new FieldImpl("id", Types.INTEGER, this, true);
  public final Field name = new FieldImpl("name", Types.INTEGER, this, true);
  public final Field age = new FieldImpl("age", Types.INTEGER, this, true);

  @Override
  public List<Field> fields() {
    return Arrays.asList(id, name, age);
  }
}
