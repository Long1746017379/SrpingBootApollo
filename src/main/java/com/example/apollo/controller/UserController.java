package com.example.apollo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.apollo.entity.User;
import com.example.apollo.service.UserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;
import java.util.List;
import java.util.UUID;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/02/06 16:11
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/navigation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Value("${server.user.name}")
    private String name;

    @Autowired
    UserService userService;

    /**
     * post请求，测试JSONObject
     *
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/queryUser")
    public List<User> queryUser(@RequestBody JSONObject jsonObject) {
        List<User> userList = Lists.newArrayList();
        log.info("==========>>>queryUser接口入参：{}", jsonObject);
        try {
            userList = userService.queryUser();
            log.info("==========>>>queryUser接口返回值：{}", userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }



    /**
     * 2021-02-24 z.w.l add
     * 用户模块：添加用户
     */
    @ResponseBody
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody  User user){
        log.info("--------用户模块：进入addUser添加用户方法--------");
        int res=0;
        try {
            if(user!=null){
                log.info("用户模块：addUser 添加用户方法==获取参数成功=="+user);
                user.setId(UUID.randomUUID().toString());
                res=userService.addUser(user);
            }else{
                log.info("用户模块：addUser 添加用户方法==获取参数失败=="+user);
            }
        } catch (Exception e) {
            log.error("用户模块：addUser 添加用户方法==出现异常=="+e);
        }
        return res+"";
    }


    /**
     *2021-02-25 z.w.l add
     * 用户模块：修改用户信息方法
     */
    @ResponseBody
    @PutMapping(value = "/updateUser")
    public String updateUser(@RequestBody User user){
        log.info("--------用户模块：updateUser修改用户信息方法--------");
        int res=0;
        try {
            if(user!=null && !user.getId().equals("")){
                log.info("用户模块：updateUser修改用户信息方法==获取数据成功=="+user);
                res=userService.updateUser(user);
            }else{
                log.info("用户模块：updateUser修改用户信息方法==获取数据失败=="+user);
            }
        } catch (Exception e) {
            log.error("用户模块：updateUser修改用户信息方法==出现异常=="+e);
        }

        return res+"";
    }

    /**
     *2021-02-27 z.w.l add
     * 用户模块：删除用户方法
     */
    @ResponseBody
    @DeleteMapping(value = "/deleteUser")
    public  String deleteUser(@RequestBody User user){
        log.info("--------用户模块Controller：删除用户方法deleteUser--------");
        int res=0;
        try {
            if(user!=null && !user.getId().equals("")){
                log.info("用户模块Controller：删除用户方法deleteUser==获取数据成功=="+user);
                res=userService.deleteUser(user);
            }else {
                log.info("用户模块Controller：删除用户方法deleteUser==获取数据失败=="+user);
            }
        } catch (Exception e) {
            log.error("用户模块Controller：删除用户方法deleteUser==出现异常=="+e);
        }

        return  res+"";
    }





    /*------------------------测试区-------------------------*/
    /**
     * get请求，测试读取配置文件信息
     *
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/hello")
    public String user() {
        log.info("从配置文件获取的值为：{}", name);
        return "Hello SpringBootApollo：" + name;
    }



    /**
     * 测试RestFul风格的RequestMapping，method = RequestMethod.GET/POST
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public Integer sub (@RequestBody JSONObject jsonObject) {
        Integer num1;
        Integer num2;
        Integer sub = null;
        try {
            num1 = jsonObject.getInteger("num1");
            num2 = jsonObject.getInteger("num2");
            sub = userService.sub(num1, num2);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("JSONObject 类型类型转换异常：{}", e.getMessage());
        }
        return sub;
    }



}
