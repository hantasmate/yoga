/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.Executor;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.concept.Part;
import com.hantasmate.yoga.core.enums.PartType;

/**
 * GroupBy
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface GroupBy extends Executor, Part {

  default PartType name() {
    return PartType.GROUP_BY;
  }

  /**
   * orderBy
   *
   * @param orders 涉及到的排序字段
   * @return ORDER BY 声明
   */
  OrderBy orderBy(Order... orders);
}
