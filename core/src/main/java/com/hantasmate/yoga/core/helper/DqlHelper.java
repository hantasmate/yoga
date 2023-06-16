/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.core.helper;

import com.hantasmate.yoga.core.concept.Field;
import com.hantasmate.yoga.core.concept.Order;
import com.hantasmate.yoga.core.concept.Predicate;
import com.hantasmate.yoga.core.concept.Table;
import com.hantasmate.yoga.core.context.DslContext;
import com.hantasmate.yoga.core.keyword.From;
import com.hantasmate.yoga.core.keyword.GroupBy;
import com.hantasmate.yoga.core.keyword.OrderBy;
import com.hantasmate.yoga.core.keyword.Select;
import com.hantasmate.yoga.core.keyword.Where;
import com.hantasmate.yoga.core.keyword.impl.SelectImpl;

/**
 * DqlHelper
 *
 * @author tabuyos
 * @since 2023/3/7
 */
public class DqlHelper implements Helper {

  public static void init(String[] args) {
    /*
    predicates are recursive

    the essence of SELECT query is a table

    and: in mathematical logic, a universal quantification is a type of quantifier
    or: in predicate logic, an existential quantification is a type of quantifier
    predicate: and, or

    Where(Predicate, ...)
    Predicate() => And(Predicate(), ...)
    Predicate() => Or(Predicate(), ...)

    1> select id, name from user;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.class)
             .execute();

    2> select id, name from user where id = 1;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.class)
             .where(USER.ID.eq(1))
             .execute();

    3> select id, name from user where id = 1 and name = 'YOUR_NAME';
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.class)
             .where(USER.ID.eq(1), USER.NAME.eq("YOUR_NAME")) ;; The default is the universal quantifier(and)
             .execute();

    4> select id, name from user where id = 1 or name = 'YOUR_NAME';
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.class)
             .where(or(USER.ID.eq(1), USER.NAME.eq("YOUR_NAME")))
             .execute();

    5> select id, name from user where (id = 1 or name = 'YOUR_NAME') and age = 18;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.class)
             .where(or(USER.ID.eq(1), USER.NAME.eq("YOUR_NAME")), USER.AGE.eq(18))
             .execute();

    6> select id, name from user where id = 1 or (name = 'YOUR_NAME' and age = 18);
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.class)
             .where(or(USER.ID.eq(1), and(USER.NAME.eq("YOUR_NAME"), USER.AGE.eq(18))))
             .execute();

    7> select id, name from user as u;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.as("u"))
             .execute();

    8> select id, name from user as u join order as o;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.as("u").join(ORDER.as("o")))
             .execute();

    9> select id, name from user as u join order as o on u.id = o.user_id;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.as("u"),
                   join(ORDER.as("o")).on(USER.ID.eq(ORDER.USER_ID)))
             .execute();

    10> select id, name from user as u join order as o on u.id = o.user_id join system on system.id = order.system_id;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER.as("u"),
                   join(ORDER.as("o")).on(USER.ID.eq(ORDER.USER_ID)),
                   join(SYSTEM).on(SYSTEM.ID.eq (ORDER .SYSTEM_ID)))
             .execute();

    11> select sum(course), count(*) from user group by age;
    DqlHelper.select(sum(USER.COURSE), count(asterisk()), ...)
             .from(USER)
             .groupBy(USER.AGE)
             .execute();

    12> select sum(course), count(*) from user group by age;
    DqlHelper.select(sum(USER.COURSE), count(asterisk()), ...)
             .from(USER)
             .groupBy(USER.AGE)
             .execute();

    13> select sum(course), count(*) from user group by age having age > 18;
    DqlHelper.select(sum(USER.COURSE), count(asterisk()), ...)
             .from(USER)
             .groupBy(USER.AGE)
             .having(USER.AGE.gt(18))
             .execute();

    14> select id, name from user order by age asc;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER)
             .orderBy(USER.AGE)
             .execute();

    15> select id, name from user order by age asc;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER)
             .orderByAsc(USER.AGE)
             .execute();

    16> select id, name from user order by age desc;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER)
             .orderByDesc(USER.AGE)
             .execute();

    17> select id, name from user order by age desc, id desc;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER)
             .orderByDesc(USER.AGE, USER.ID)
             .execute();

    18> select id, name from user order by age desc, id;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER)
             .orderBy(USER.AGE.desc(), USER.ID)
             .execute();

    19> select distinct id, name from user order by age desc, id;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .hint(distinct())
             .from(USER)
             .orderBy(USER.AGE.desc(), USER.ID)
             .execute();

    20> select id, name from user order by age desc, id limit 10 offset 2;
    DqlHelper.select(USER.ID, USER.NAME, ...)
             .from(USER)
             .orderBy(USER.AGE.desc(), USER.ID)
             .limit(10)
             .offset(2)
             .execute();
     */

    // DqlHelper.of().select(User.id, User.name).from(new User()).execute();
    // DqlHelper.of().select(User.id, User.name).from(new User()).where().execute();
    // DqlHelper.of().select(User.id, User.name).from(new User()).where().groupBy().execute();
    // DqlHelper.of().select(User.id, User.name).from(new User()).where().orderBy().execute();
  }

  public static Select create() {
    return new SelectImpl(new DslContext(null));
  }
}
