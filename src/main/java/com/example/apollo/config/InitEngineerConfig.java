package com.example.apollo.config;

import com.example.apollo.dao.TAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/03/13 0:05
 */
@Configuration
public class InitEngineerConfig {

    @Autowired
    TAreaDao tAreaDao;

    public static Map<Integer, String> provMapping = new HashMap<>();

    public static Map<Integer, String> eparchyMapping = new HashMap<>();

    public static Map<Integer, String> districtMapping = new HashMap<>();

    /**
     * 获取省/市/区 Map映射
     */
    @Bean
    public void getProvEparchDisMap() {
        provMapping = tAreaDao.getProvEparchDisMap(10);
        eparchyMapping = tAreaDao.getProvEparchDisMap(20);
        districtMapping = tAreaDao.getProvEparchDisMap(30);
    }


}
