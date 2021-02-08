package com.example.apollo.service.impl;

import com.example.apollo.dao.UserDao;
import com.example.apollo.entity.User;
import com.example.apollo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/02/07 23:19
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Integer sum(Integer num1, Integer num2) {
        List<User> list = userDao.queryAll();
        log.error("list：{}", list);
        return num1 + num2;
    }

    @Override
    public Integer sub(Integer num1, Integer num2) {
        return num1 - num2;
    }
}
