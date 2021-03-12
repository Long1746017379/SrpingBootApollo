package com.example.apollo.dao;

import com.example.apollo.entity.ProvEparchDisMap;
import com.example.apollo.entity.TArea;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TAreaDao {

    int deleteByPrimaryKey(String areaCode);

    int insert(TArea record);

    int insertSelective(TArea record);

    TArea selectByPrimaryKey(String areaCode);

    int updateByPrimaryKeySelective(TArea record);

    int updateByPrimaryKey(TArea record);

    List<ProvEparchDisMap> getProvEparchDisMap(int area_level);

}