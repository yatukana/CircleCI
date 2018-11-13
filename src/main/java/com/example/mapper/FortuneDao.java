package com.example.mapper;

import com.example.entity.FortuneEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FortuneDao {

    public String selectOneByNum(@Param("id") int id);

    public Integer selectOneNumAll();

    public String selectTwoByNum(@Param("id") int id);

    public Integer selectTwoNumAll();

    public String selectThreeByNum(@Param("id") int id);

    public Integer selectThreeNumAll();

}