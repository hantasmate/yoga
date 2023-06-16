/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword.impl;

import com.hantasmate.yoga.core.concept.Alias;
import com.hantasmate.yoga.core.concept.Context;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.concept.Predicate;
import com.hantasmate.yoga.core.concept.Table;
import com.hantasmate.yoga.core.concept.impl.PairImpl;
import com.hantasmate.yoga.core.enums.JoinType;
import com.hantasmate.yoga.core.keyword.From;
import com.hantasmate.yoga.core.keyword.GroupBy;
import com.hantasmate.yoga.core.keyword.OrderBy;
import com.hantasmate.yoga.core.keyword.Where;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * FromImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class FromImpl implements From {

  private final Context context;
  private List<Table> tables;

  public FromImpl(Context context) {
    this.context = context;
    this.context.addPart(this);
    this.tables = context.tables();
  }

  @Override
  public List<Table> tables() {
    return tables;
  }

  @Override
  public Where where(Predicate... predicates) {
    context.predicates(Arrays.stream(predicates).collect(Collectors.toList()));
    return new WhereImpl(context());
  }

  @Override
  public GroupBy groupBy(Field... fields) {
    return new GroupByImpl(context());
  }

  @Override
  public OrderBy orderBy(Order... orders) {
    return new OrderByImpl(context());
  }

  @Override
  public Context context() {
    return context;
  }

  private String processQuantificationPredicate(Predicate predicate) {
    StringJoiner predicateJoiner =
        new StringJoiner(" " + predicate.quantifier().name() + " ", "(", ")");

    predicate
        .pairs()
        .forEach(
            jp -> {
              if (jp.quantifier() != null) {
                predicateJoiner.add(processQuantificationPredicate(jp));
                return;
              }
              if (jp.isBare()) {
                predicateJoiner.add(
                    jp.field().qualifiedName() + "=" + ((Field) jp.value()).qualifiedName());
                return;
              }
              context.bindValues().add(new PairImpl(jp.value().getClass(), jp.value()));
              predicateJoiner.add(jp.field().qualifiedName() + "=?");
            });
    return predicateJoiner.toString();
  }

  @Override
  public void process(StringJoiner sqlJoiner) {
    sqlJoiner.add("from");
    StringJoiner tablePartJoiner = new StringJoiner(" ");
    tables.stream()
        .map(
            table -> {
              String joinKey =
                  Optional.ofNullable(table.type()).map(JoinType::delimiter).orElse("");
              String joinPredicate =
                  Optional.ofNullable(table.joinPredicate())
                      .map(
                          jp -> {
                            // 非量化则 pairs 一定为空
                            if (jp.quantifier() == null) {
                              if (jp.isBare()) {
                                return jp.field().qualifiedName()
                                    + "="
                                    + ((Field) jp.value()).qualifiedName();
                              }
                              context
                                  .bindValues()
                                  .add(new PairImpl(jp.value().getClass(), jp.value()));
                              return jp.field().qualifiedName() + "=?";
                            }
                            return processQuantificationPredicate(jp);
                          })
                      .map(jps -> " on " + jps)
                      .orElse("");
              return Optional.ofNullable(table.alias())
                  .map(Alias::name)
                  .map(alias -> joinKey + " " + table.name() + " as " + alias + joinPredicate)
                  .orElse(table.name());
            })
        .forEach(tablePartJoiner::add);
    sqlJoiner.add(tablePartJoiner.toString());
  }
}
