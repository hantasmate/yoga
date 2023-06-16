/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.concept;

import java.util.List;
import java.util.StringJoiner;

/**
 * Context
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public interface Context extends Concept {

  String sql();
  List<Pair> bindValues();
  Configuration configuration();
  void addPart(Part part);
  List<Part> parts();
  List<Field> fields();
  void fields(List<Field> fields);
  List<Table> tables();
  void tables(List<Table> tables);
  List<Predicate> predicates();
  void predicates(List<Predicate> predicates);
  void process();
  boolean isJoin();
  void enableJoin();
  boolean isValue();
  void enableValue();
}
