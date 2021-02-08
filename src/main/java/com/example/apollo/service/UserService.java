package com.example.apollo.service;

import com.example.apollo.entity.User;

import java.util.List;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/02/07 23:19
 */
public interface UserService {

    List<User> queryUser();

    Integer sub(Integer num1, Integer num2);
}
