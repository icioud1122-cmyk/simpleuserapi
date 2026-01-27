package com.example.simpleuserapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "名前は必須です")
    private String name;

    @Min(value = 0, message = "年齢は0以上で入力してください")
    private int age;

    // getter/setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
