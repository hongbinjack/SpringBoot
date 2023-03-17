package com.hb.domain;
//lombok

import lombok.Data;
/*
  @Getter和@Setter:通过这两个注解，可以不用自己生成get和set方法
  @Data = @Getter + @Setter 不仅生成了对应的get和set方法，对应的hashcode方法和equals方法和toString方法也生成了
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
