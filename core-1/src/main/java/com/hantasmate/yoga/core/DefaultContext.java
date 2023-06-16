/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Context
 *
 * @author tabuyos
 * @since 2023/3/15
 */
public class DefaultContext {

  private final List<Context> contexts = new ArrayList<>();

  public String sql() {
    return "";
  }

  public List<String> bindValues() {
    return new ArrayList<>();
  }

  public void runOnContext() {
    contexts.forEach(Context::doContext);
  }

  public void appendContext(Context context) {
    contexts.add(context);
  }

  public List<Context> contexts() {
    return contexts.stream()
        .sorted(Comparator.comparing(Context::index))
        .collect(Collectors.toList());
  }
}
