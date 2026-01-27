package com.example.simpleuserapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
    private Long id;

    @NotBlank(message = "名前は必須です")
    private String name;

    @Min(value = 0, message = "年齢は0以上で入力してください")
    private int age;

    // getter / setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
