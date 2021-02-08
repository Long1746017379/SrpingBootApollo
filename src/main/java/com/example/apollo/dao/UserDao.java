package com.example.apollo.dao;

import com.example.apollo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> queryAll();

}