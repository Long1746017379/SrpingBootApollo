package com.example.apollo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.apollo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
        log.info("222222222");
        log.info("222222222");
        return "Hello SpringBootApollo：" + name;
    }

    /**
     * post请求，测试JSONObject
     *
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/sum")
    public Integer sum(@RequestBody JSONObject jsonObject) {
        Integer num1;
        Integer num2;
        Integer sum = null;
        try {
            num1 = jsonObject.getInteger("num1");
            num2 = jsonObject.getInteger("num2");
            sum = userService.sum(num1, num2);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("JSONObject 类型类型转换异常：{}", e.getMessage());
        }
        return sum;
    }


}
