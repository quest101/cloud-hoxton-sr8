package com.ken.dto;

import lombok.Data;


@Data
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
