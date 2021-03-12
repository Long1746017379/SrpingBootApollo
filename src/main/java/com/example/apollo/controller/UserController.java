package com.example.apollo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.apollo.config.InitEngineerConfig;
import com.example.apollo.entity.User;
import com.example.apollo.service.UserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

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
     * get请求，测试读取配置文件信息
     *
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/hello")
    public String user() {
        log.info("从配置文件获取的值为：{}", name);
        log.info("省份Map大小：{}，内容：{}", InitEngineerConfig.provMapping.size(), InitEngineerConfig.provMapping);
        log.info("地市Map大小：{}，内容：{}", InitEngineerConfig.eparchyMapping.size(), InitEngineerConfig.eparchyMapping);
        log.info("区县Map大小：{}，内容：{}", InitEngineerConfig.districtMapping.size(), InitEngineerConfig.districtMapping);

        if (InitEngineerConfig.provMapping.containsKey("河北")) {
            log.info("Value：{}", InitEngineerConfig.provMapping.get("河北"));
        }

        return "Hello SpringBootApollo：" + name;
    }

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
     * 测试RestFul风格的RequestMapping，method = RequestMethod.GET/POST
     *
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public Integer sub(@RequestBody JSONObject jsonObject) {
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


    @PostMapping("/test")
    public void test(@Valid @RequestBody User user) {
        log.info("请求入参:{}", user);
        log.info("phone:{}", user.getPersonPhone());
        log.info("age:{}", user.getAge());

        int i = 1;
        System.out.println(i / 0);

        Map map = null;
        map.put("key", "key");

    }

}
