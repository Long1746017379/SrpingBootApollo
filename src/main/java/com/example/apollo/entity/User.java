package com.example.apollo.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User extends Person {

    @NotNull(message = "userId不能为空")
    private String userId;

    private String userName;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + super.getPersonPhone() + '\'' +
                ", age='" + super.getAge() + '\'' +
                '}';
    }


}
