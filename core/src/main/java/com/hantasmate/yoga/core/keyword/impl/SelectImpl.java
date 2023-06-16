/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.keyword.impl;

import com.hantasmate.yoga.core.concept.Alias;
import com.hantasmate.yoga.core.concept.Context;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.KeyWord;
import com.hantasmate.yoga.core.concept.Table;
import com.hantasmate.yoga.core.keyword.From;
import com.hantasmate.yoga.core.keyword.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * SelectImpl
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class SelectImpl implements Select {

  private final Context context;
  private List<Field> fields;
  private List<KeyWord> hints;

  public SelectImpl(Context context) {
    this.context = context;
    this.fields = new ArrayList<>();
    this.hints = new LinkedList<>();
    this.context.addPart(this);
  }

  @Override
  public List<Field> fields() {
    return fields;
  }

  @Override
  public From from(Table... tables) {
    context.fields(fields);
    context.tables(Arrays.stream(tables).collect(Collectors.toList()));
    return new FromImpl(context);
  }

  @Override
  public Select select(Field... fields) {
    this.fields.addAll(Arrays.stream(fields).collect(Collectors.toList()));
    return this;
  }

  @Override
  public Select hint(KeyWord... keyWords) {
    this.hints.addAll(Arrays.stream(keyWords).collect(Collectors.toList()));
    return this;
  }

  @Override
  public Context context() {
    return context;
  }

  @Override
  public void process(StringJoiner sqlJoiner) {
    sqlJoiner.add("select");
    hints.forEach(hint -> sqlJoiner.add(hint.keyword()));
    StringJoiner fieldPartJoiner = new StringJoiner(", ");
    fields.stream()
        .map(
            field ->
                Optional.ofNullable(field.alias())
                    .map(Alias::name)
                    .map(alias -> field.qualifiedName() + " as " + alias)
                    .orElse(field.qualifiedName()))
        .forEach(fieldPartJoiner::add);
    sqlJoiner.add(fieldPartJoiner.toString());
  }
}
