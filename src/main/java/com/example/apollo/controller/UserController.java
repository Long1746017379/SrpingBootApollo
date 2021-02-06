package com.example.apollo.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/user")
    public String user(){
        JSONObject jsonObject = new JSONObject();
        log.info("jsonObject:{}", jsonObject);
        return "Hello SpringBootApollo";
    }


}
