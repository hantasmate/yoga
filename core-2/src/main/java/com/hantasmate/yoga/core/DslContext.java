/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.pair.HandlerPair;
import com.hantasmate.yoga.core.tuple.TwoTuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DslContext
 *
 * @author tabuyos
 * @since 2023/3/16
 */
public class DslContext implements Context {

  private final List<HandlerPair> handlerPairs = new ArrayList<>();
  private final List<TwoTuple<Integer, Object>> bindValues = new ArrayList<>();
  private final StringBuilder sqlBuilder = new StringBuilder();

  public StringBuilder sqlBuilder() {
    return sqlBuilder;
  }

  public String pureSql() {
    return sqlBuilder.toString();
  }

  public List<TwoTuple<Integer, Object>> bindValues() {
    return bindValues;
  }

  public void doHandle() {
    handlers().forEach(Handler::handle);
  }

  public void addHandler(Handler handler) {
    addHandler(handler, Priority.DEFAULT);
  }

  public void addHandler(Handler handler, int priority) {
    HandlerPair pair = HandlerPair.of(priority, handler);
    handlerPairs.add(pair);
  }

  public List<Handler> handlers() {
    return handlerPairs.stream()
        .sorted(Comparator.comparing(HandlerPair::priority))
        .map(HandlerPair::handler)
        .collect(Collectors.toList());
  }
}
