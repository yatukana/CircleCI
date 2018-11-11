package com.example.mapper;

import com.example.entity.FortuneEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FortuneDao {

    public FortuneEntity select();

}