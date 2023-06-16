/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

import com.hantasmate.yoga.core.enums.PartType;

import java.util.StringJoiner;

/**
 * Part
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public interface Part extends Concept {

  PartType name();

  void process(StringJoiner sqlJoiner);
}
