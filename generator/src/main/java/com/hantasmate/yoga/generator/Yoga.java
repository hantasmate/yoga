package com.hantasmate.yoga.generator;

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;

/**
 * 测试
 * <p> code auto generate by yoga.
 *
 * @author tabuyos
 * @since 2023/03/20
 */
public class Yoga extends TableImpl {

  public Yoga() {
    super("yoga", true);
  }

  /**
   * 测试列
   */
  public final Field id = new FieldImpl("id", Types.INTEGER, this, true);

  /**
   * 测试列
   */
  public final Field name = new FieldImpl("name", Types.INTEGER, this, true);

  /**
   * 测试列
   */
  public final Field age = new FieldImpl("age", Types.INTEGER, this, true);

  /**
   * 测试列
   */
  public final Field createTime = new FieldImpl("create_time", Types.INTEGER, this, true);

  /**
   * 测试列
   */
  public final Field creator = new FieldImpl("creator", Types.INTEGER, this, true);

  @Override
  public List<Field> fields() {
    return Arrays.asList(id, name, age, createTime, creator);
  }
}
