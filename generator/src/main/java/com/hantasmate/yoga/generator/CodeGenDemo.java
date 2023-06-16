/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.generator;

import com.google.common.base.CaseFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * CodeGenDemo
 *
 * @author tabuyos
 * @since 2023/3/19
 */
public class CodeGenDemo {

  public static void main1(String[] args) throws IOException, TemplateException {
    // Map<String, Object> objectMap = new HashMap<>();
    // //定义包路径
    // objectMap.put("package", "com.hantasmate.yoga.generator");
    // //定义实体类
    // objectMap.put("entityClass", "Student");
    //
    // //定义实体类属性
    // List<Map<String, Object>> columns = new ArrayList<>();
    // //姓名字段
    // Map<String, Object> column1 = new HashMap<>();
    // column1.put("propertyType", "String");
    // column1.put("propertyName", "name");
    // column1.put("comment", "姓名");
    // columns.add(column1);
    // //年龄字段
    // Map<String, Object> column2 = new HashMap<>();
    // column2.put("propertyType", "Integer");
    // column2.put("propertyName", "age");
    // column2.put("comment", "年龄");
    // columns.add(column2);
    //
    // //定义类的属性
    // objectMap.put("columns", columns);
    // //定义作者
    // objectMap.put("author", "张三");
    // //定义创建时间
    // objectMap.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    // //定义类描述
    // objectMap.put("tableComment", "学生信息");
    //
    // //生产目标代码
    // Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
    // configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
    // configuration.setClassForTemplateLoading(CodeGenDemo.class, "/");
    // Template template = configuration.getTemplate("/entity.java.ftl");
    // File dir = new File("generator/src/main/java/com/hantasmate/yoga/generator");
    // if (!dir.exists()) {
    //   boolean ignore = dir.mkdirs();
    // }
    // FileOutputStream fileOutputStream = new FileOutputStream(Paths.get(dir.getAbsolutePath(),
    // "Student.java").toFile());
    // template.process(objectMap, new OutputStreamWriter(fileOutputStream,
    // StandardCharsets.UTF_8));
    // fileOutputStream.close();
    // System.out.println("文件创建成功");

    System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "input_in_snake_case"));
  }

  public static void main(String[] args) throws IOException, TemplateException {
    String originalTable = "yoga";
    String[] originalFields = new String[]{"id", "name", "age", "create_time", "creator"};
    List<String> fields = Arrays.stream(originalFields).map(of -> CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, of)).collect(Collectors.toList());
    String table = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, originalTable);

    Map<String, Object> metadata = new HashMap<>(16);
    metadata.put("package", "com.hantasmate.yoga.generator");
    metadata.put("comment", "测试");
    metadata.put("author", "tabuyos");
    metadata.put("date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
    metadata.put("table", table);
    metadata.put("o_table", originalTable);
    List<Map<String, Object>> fieldsMap = new ArrayList<>();
    for (String field : originalFields) {
      Map<String, Object> fieldMap = new HashMap<>();
      fieldMap.put("comment", "测试列");
      fieldMap.put("o_name", field);
      fieldMap.put("c_name", CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, field));
      fieldsMap.add(fieldMap);
    }
    metadata.put("fields", fieldsMap);
    metadata.put("n_fields", fields);

    // 生产目标代码
    Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
    configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
    configuration.setClassForTemplateLoading(CodeGenDemo.class, "/");
    Template template = configuration.getTemplate("/templates/metadata.java.ftl");
    File dir = new File("generator/src/main/java/com/hantasmate/yoga/generator");
    if (!dir.exists()) {
      boolean ignore = dir.mkdirs();
    }
    FileOutputStream fileOutputStream = new FileOutputStream(Paths.get(dir.getAbsolutePath(),
    "Yoga.java").toFile());
    template.process(metadata, new OutputStreamWriter(fileOutputStream,
    StandardCharsets.UTF_8));
    fileOutputStream.close();
    System.out.println("文件创建成功");
  }
}
