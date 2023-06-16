/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.Executor;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.concept.Part;
import com.hantasmate.yoga.core.concept.Predicate;
import com.hantasmate.yoga.core.enums.PartType;

/**
 * Where
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Where extends Executor, Part {

  default PartType name() {
    return PartType.WHERE;
  }

  /**
   * groupBy
   *
   * @param fields 涉及到的分组字段
   * @return GROUP BY 声明
   */
  GroupBy groupBy(Field... fields);

  /**
   * orderBy
   *
   * @param orders 涉及到的排序字段
   * @return ORDER BY 声明
   */
  OrderBy orderBy(Order... orders);
}
