package com.imaginist.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Pet tomcat;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
