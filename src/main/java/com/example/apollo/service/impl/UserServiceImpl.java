package com.example.apollo.service.impl;

import com.example.apollo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/02/07 23:19
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Integer sum(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public Integer sub(Integer num1, Integer num2) {
        return num1 - num2;
    }
}
