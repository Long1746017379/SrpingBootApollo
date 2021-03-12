package com.example.apollo.dao;

import com.example.apollo.entity.TArea;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TAreaDao {

    int deleteByPrimaryKey(String areaCode);

    int insert(TArea record);

    int insertSelective(TArea record);

    TArea selectByPrimaryKey(String areaCode);

    int updateByPrimaryKeySelective(TArea record);

    int updateByPrimaryKey(TArea record);

    Map<Integer, String> getProvEparchDisMap(int area_level);
}