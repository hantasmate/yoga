/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.entity;

import java.util.StringJoiner;

/**
 * User
 *
 * @author tabuyos
 * @since 2023/3/8
 */
public class User {
  private Long id;
  private String name;
  private Integer age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "(", ")")
      .add("id=" + id)
      .add("name='" + name + "'")
      .add("age=" + age)
      .toString();
  }
}
