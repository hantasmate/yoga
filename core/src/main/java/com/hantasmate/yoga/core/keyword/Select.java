/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.ContextProvider;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.KeyWord;
import com.hantasmate.yoga.core.concept.Part;
import com.hantasmate.yoga.core.concept.Table;
import com.hantasmate.yoga.core.enums.PartType;

import java.util.List;

/**
 * Select
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Select extends ContextProvider, Part {

  default PartType name() {
    return PartType.SELECT;
  }

  List<Field> fields();

  /**
   * from
   *
   * @param tables 涉及到的表
   * @return FROM 声明
   */
  From from(Table... tables);

  /**
   * select
   *
   * @param fields 涉及到的字段
   * @return SELECT 声明
   */
  Select select(Field... fields);

  Select hint(KeyWord... keyWords);
}
