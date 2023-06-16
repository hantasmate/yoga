package com.hantasmate.yoga.core.helper;

import com.hantasmate.yoga.core.entity.UserInfo;
import org.junit.jupiter.api.Test;

import static com.hantasmate.yoga.core.DSL.eq;
import static com.hantasmate.yoga.core.DSL.join;
import static com.hantasmate.yoga.core.DSL.keyword;
import static com.hantasmate.yoga.core.DSL.or;
import static com.hantasmate.yoga.core.DSL.order;

@SuppressWarnings("ConstantConditions")
class DqlHelperTestMain {
  static final UserInfo USER = new UserInfo();
  static final UserInfo ORDER = new UserInfo();
  static final UserInfo DEPT = new UserInfo();

  @Test
  void create() {
    DqlHelper.create()
        .select(USER.ID.as("sj"), USER.NAME)
        .hint(keyword("distinct"))
        .from(USER, join(ORDER.as("uu")).on(eq(USER.ID, ORDER.ID)), join(DEPT.as("dd")).on(eq(DEPT.ID, ORDER.ID)))
        .where(eq(USER.ID, 1), or())
        .groupBy(USER.ID)
        .orderBy(order(USER.AGE))
        .execute();
    // System.out.println(eq(USER.ID, 1).pairs().size());
  }
}
