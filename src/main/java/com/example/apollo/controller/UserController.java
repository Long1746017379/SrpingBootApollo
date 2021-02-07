package com.example.apollo.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
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

    @ResponseBody
    @GetMapping(value = "/hello")
    public String user(){
        log.info("从配置文件获取的值为：{}", name);
        return "Hello SpringBootApollo：" + name;
    }


    @ResponseBody
    @PostMapping(value = "/sum")
    public int sum(@RequestBody JSONObject jsonObject){
        Integer num1 = null;
        Integer num2 = null;
        try {
            num1 = jsonObject.getInteger("num1");
            num2 = jsonObject.getInteger("num2");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("JSONObject 类型类型转换异常：{}", e.getMessage());
        }
        return num1 + num2;
    }


}
