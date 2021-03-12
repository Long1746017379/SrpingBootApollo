package com.example.apollo.config;

import com.example.apollo.dao.TAreaDao;
import com.example.apollo.entity.ProvEparchDisMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
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

    public static Map<String, String> provMapping = new HashMap<>();

    public static Map<String, String> eparchyMapping = new HashMap<>();

    public static Map<String, String> districtMapping = new HashMap<>();


    /**
     * 获取省/市/区 Map映射
     */
    @Bean
    public void getProvEparchDisMap() {
        List<ProvEparchDisMap> provList = tAreaDao.getProvEparchDisMap(10);
        for (ProvEparchDisMap provEparchDisMap : provList) {
            provMapping.put(provEparchDisMap.getValue(),provEparchDisMap.getCode());
        }

        List<ProvEparchDisMap> eparchList = tAreaDao.getProvEparchDisMap(20);
        for (ProvEparchDisMap provEparchDisMap : eparchList) {
            eparchyMapping.put(provEparchDisMap.getValue(),provEparchDisMap.getCode());
        }

        List<ProvEparchDisMap> districtList = tAreaDao.getProvEparchDisMap(30);
        for (ProvEparchDisMap provEparchDisMap : districtList) {
            districtMapping.put(provEparchDisMap.getValue(),provEparchDisMap.getCode());
        }


    }


}
