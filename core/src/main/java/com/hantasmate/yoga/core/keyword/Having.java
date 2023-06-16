/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword;

import com.hantasmate.yoga.core.concept.Executor;
import com.hantasmate.yoga.core.concept.Part;
import com.hantasmate.yoga.core.enums.PartType;

/**
 * Having
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public interface Having extends Executor, Part {

  default PartType name() {
    return PartType.HAVING;
  }
}
