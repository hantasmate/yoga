/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.provider;

import com.google.common.base.CaseFormat;
import com.hantasmate.yoga.core.ContextProvider;
import com.hantasmate.yoga.core.YogaContext;
import com.hantasmate.yoga.core.contant.Snippet;
import com.hantasmate.yoga.core.context.ValuesContext;
import com.hantasmate.yoga.core.pair.BindPair;
import com.hantasmate.yoga.core.Field;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Supplier;

/**
 * ValuesContextProvider
 *
 * @author tabuyos
 * @since 2023/3/21
 */
public interface ValuesContextProvider
    extends ContextProvider<ValuesContext, YogaContext, StringBuilder>, ValuesContext {

  /**
   * process closure string
   *
   * @param closure closure string
   */
  @Override
  default void doClosure(String closure) {
    if (snippet().length() == 0) {
      snippet().append(closure);
    } else {
      snippet().append(Snippet.COMMA_S).append(closure);
    }
  }

  @Override
  default ValuesContext provide() {
    return this;
  }

  @Override
  default void plain(String segment) {
    doClosure(segment);
  }

  @Override
  default <E> void values(E entity) {
    List<Object> values = readValueOfEntity(entity);
    values(values.toArray(new Object[0]));
  }

  @Override
  default <E> void values(Collection<E> entities) {
    if (!Optional.ofNullable(entities).filter(es -> es.size() > 0).isPresent()) {
      return;
    }
    entities.forEach(this::values);
  }

  @Override
  default void values(Object... values) {
    List<Field> fields = context().fields();
    int size = fields.size();
    if (values.length != size) {
      throw new RuntimeException("field and value not match.");
    }
    StringJoiner joiner = new StringJoiner(Snippet.COMMA_S, Snippet.LEFT_PARENTHESES, Snippet.RIGHT_PARENTHESES);
    for (int i = 0; i < values.length; i++) {
      Object value = values[i];
      joiner.add(Snippet.PLACEHOLDER);
      context().bindValues().add(BindPair.of(value, fields.get(i).type()));
    }
    doClosure(joiner.toString());
  }

  @Override
  default void values(Supplier<?>... suppliers) {
    values(Arrays.stream(suppliers).map(Supplier::get).toArray());
  }

  default <E> List<Object> readValueOfEntity(E entity) {
    List<Object> values = new ArrayList<>();
    try {
      Class<?> clazz = entity.getClass();
      List<Field> fields = context().fields();
      for (Field field : fields) {
        String name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, field.name());
        PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
        Optional.ofNullable(pd.getReadMethod().invoke(entity)).ifPresent(values::add);
      }
    } catch (IntrospectionException e) {
      throw new RuntimeException("property descriptor with error!");
    } catch (InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException("invoke with error!");
    }
    return values;
  }
}
