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

    /**
     * 2021-02-24 z.w.l add
     * 查询用户全部信息
     */
    int addUser(User user);

    /**
     *2021-02-25 z.w.l add
     * 用户模块：修改用户信息方法
     */
    int updateUser(User user);

    /**
     *2021-02-27 z.w.l add
     * 用户模块：删除用户方法
     */
    int deleteUser(User user);
}
