/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.context;

import com.hantasmate.yoga.core.concept.Configuration;
import com.hantasmate.yoga.core.concept.Context;
import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Pair;
import com.hantasmate.yoga.core.concept.Part;
import com.hantasmate.yoga.core.concept.Predicate;
import com.hantasmate.yoga.core.concept.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * DslContext
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class DslContext implements Context {
  private StringJoiner sqlJoiner;
  private List<Pair> pairs;
  private List<Part> parts;
  private List<Table> tables;
  private List<Field> fields;
  private List<Predicate> predicates;
  private boolean joinPart = false;
  private boolean valuePart = false;
  private final Configuration configuration;

  public DslContext(Configuration configuration) {
    this.sqlJoiner = new StringJoiner(" ");
    this.pairs = new ArrayList<>();
    this.parts = new ArrayList<>();
    // this.tables = new ArrayList<>();
    // this.fields = new ArrayList<>();
    // this.predicates = new ArrayList<>();
    this.configuration = configuration;
  }

  @Override
  public String sql() {
    return sqlJoiner.toString();
  }

  @Override
  public List<Pair> bindValues() {
    return pairs;
  }

  @Override
  public Configuration configuration() {
    return configuration;
  }

  @Override
  public void addPart(Part part) {
    this.parts.add(part);
  }

  @Override
  public List<Part> parts() {
    return parts;
  }

  @Override
  public List<Field> fields() {
    return fields;
  }

  @Override
  public void fields(List<Field> fields) {
    this.fields = fields;
  }

  @Override
  public List<Table> tables() {
    return tables;
  }

  @Override
  public void tables(List<Table> tables) {
    this.tables = tables;
  }

  @Override
  public List<Predicate> predicates() {
    return predicates;
  }

  @Override
  public void predicates(List<Predicate> predicates) {
    this.predicates = predicates;
  }

  @Override
  public void process() {
    parts.forEach(part -> part.process(sqlJoiner));
  }

  @Override
  public boolean isJoin() {
    return joinPart;
  }

  @Override
  public void enableJoin() {
    this.joinPart = true;
  }

  @Override
  public boolean isValue() {
    return valuePart;
  }

  @Override
  public void enableValue() {
    this.valuePart = true;
  }
}
