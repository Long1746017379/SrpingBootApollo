package com.example.apollo.service.impl;

import com.example.apollo.dao.UserDao;
import com.example.apollo.entity.User;
import com.example.apollo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    public List<User> queryUser() {
        List<User> list = new ArrayList<>();
        try {
            list = userDao.queryAll();
            if (!CollectionUtils.isEmpty(list)){
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查询异常：{}", e.getMessage());
        }
        return list;
    }

    @Override
    public Integer sub(Integer num1, Integer num2) {
        return num1 - num2;
    }


    /**
     * 2021-02-24 z.w.l add
     * 用户模块servies：addUser 添加用户方法
     */
    @Override
    public int addUser(User user) {
        int res=0;
        try {
            res=userDao.addUser(user);
        } catch (Exception e) {
            log.error("用户模块service：addUser 添加用户方法==出现异常=="+e);
        }
        return res;
    }

    /**
     *2021-02-25 z.w.l add
     * 用户模块：修改用户信息方法
     */
    @Override
    public int updateUser(User user) {
        int res=0;
        try {
            res=userDao.updateUser(user);
        } catch (Exception e) {
            log.error("用户模块service层：updateUser 修改用户信息方法==出现异常=="+e);
        }
        return res;
    }

    /**
     *2021-02-27 z.w.l add
     * 用户模块：删除用户方法
     */
    @Override
    public int deleteUser(User user) {
        int res=0;
        try {
            res=userDao.deleteUser(user);
        } catch (Exception e) {
            log.error("用户模块service：删除用户方法deleteUser==出现异常=="+e);
        }
        return res;
    }
}
