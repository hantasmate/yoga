package ${package};

import com.hantasmate.yoga.core.Field;
import com.hantasmate.yoga.core.impl.FieldImpl;
import com.hantasmate.yoga.core.impl.TableImpl;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;

/**
 * ${comment}
 * <p> code auto generate by yoga.
 *
 * @author ${author}
 * @since ${date}
 */
public class ${table} extends TableImpl {

  public ${table}() {
    super("${o_table}", true);
  }
<#--属性遍历-->
<#list fields as field>

  /**
   * ${field.comment}
   */
  public final Field ${field.c_name} = new FieldImpl("${field.o_name}", Types.INTEGER, this, true);
</#list>
<#--方法-->

  @Override
  public List<Field> fields() {
    return Arrays.asList(${n_fields?join(", ")});
  }
}
