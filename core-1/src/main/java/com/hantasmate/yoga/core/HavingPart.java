/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.util.function.Consumer;

/**
 * HavingPart
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public interface HavingPart {

  default void having(Consumer<PredicatePart> havingConsumer) {

  }
}
