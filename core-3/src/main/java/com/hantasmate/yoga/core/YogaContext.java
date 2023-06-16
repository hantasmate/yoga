/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core;

import com.hantasmate.yoga.core.contant.Priority;
import com.hantasmate.yoga.core.context.Context;
import com.hantasmate.yoga.core.interceptor.WhereContextInterceptor;
import com.hantasmate.yoga.core.pair.BindPair;
import com.hantasmate.yoga.core.pair.HandlerPair;
import com.hantasmate.yoga.core.provider.impl.WhereContextProviderImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * DslContext
 *
 * @author tabuyos
 * @since 2023/3/18
 */
public class YogaContext {

  private final List<HandlerPair> handlerPairs;
  private final List<BindPair> bindValues;
  private final List<Table> tables;
  private final List<Field> fields;
  private final List<Context> contextParts;
  private final List<ContextInterceptor> interceptors;
  private final StringBuilder sqlBuilder;

  public YogaContext() {
    this.interceptors = new ArrayList<>();
    this.contextParts = new ArrayList<>();
    this.fields = new ArrayList<>();
    this.tables = new ArrayList<>();
    this.bindValues = new ArrayList<>();
    this.handlerPairs = new ArrayList<>();
    this.sqlBuilder = new StringBuilder();
  }

  public List<BindPair> bindValues() {
    return bindValues;
  }

  public List<Table> tables() {
    return tables;
  }

  public List<Field> fields() {
    return fields;
  }

  public List<Context> contextParts() {
    return contextParts;
  }

  public StringBuilder sqlBuilder() {
    return sqlBuilder;
  }

  public String plainSql() {
    return sqlBuilder.toString();
  }

  public void addHandler(Handler handler, int priority) {
    HandlerPair pair = HandlerPair.of(priority, handler);
    handlerPairs.add(pair);
  }

  public void addHandler(Handler handler) {
    addHandler(handler, Priority.DEFAULT);
  }

  public final void addInterceptor(ContextInterceptor interceptor) {
    this.interceptors.add(interceptor);
  }

  public List<Handler> handlers() {
    return handlerPairs.stream()
        .sorted(Comparator.comparing(HandlerPair::priority))
        .map(HandlerPair::handler)
        .collect(Collectors.toList());
  }

  public void prepareContext() {
    interceptors.forEach(interceptor -> interceptor.intercept(this));
    handlers().forEach(Handler::handle);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", YogaContext.class.getSimpleName() + "(", ")")
        .add("handlerPairs=" + handlerPairs)
        .add("bindValues=" + bindValues)
        .add("tables=" + tables)
        .add("fields=" + fields)
        .add("sqlBuilder=" + sqlBuilder)
        .toString();
  }
}
