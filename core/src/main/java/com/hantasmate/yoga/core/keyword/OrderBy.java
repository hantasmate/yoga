/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.Executor;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.concept.Part;
import com.hantasmate.yoga.core.enums.PartType;

/**
 * OrderBy
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface OrderBy extends Executor, Part {

  default PartType name() {
    return PartType.ORDER_BY;
  }

  /**
   * orderBy
   *
   * @param orders 涉及到的排序字段
   * @return ORDER BY 声明
   */
  OrderBy orderBy(Order... orders);
}
