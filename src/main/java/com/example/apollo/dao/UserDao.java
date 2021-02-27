package com.example.apollo.dao;

import com.example.apollo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface UserDao {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> queryAll();

    /**
     * 2021-02-24 z.w.l add
     * 用户模块：addUser 添加用户方法
     */
    int addUser(@Param("user") User user);

    /**
     *2021-02-25 z.w.l add
     * 用户模块：修改用户信息方法
     */
    int updateUser(@Param("user") User user);

    /**
     *2021-02-27 z.w.l add
     * 用户模块：删除用户方法
     */
    int deleteUser(@Param("user") User user);
}