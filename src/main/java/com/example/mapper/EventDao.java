package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.EventEntity;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventDao {

	public EventEntity selectByUid(@Param("guid") String guid, @Param("uid") String uid, @Param("folderId") Integer folderId);

	public List<EventEntity> selectEventList(@Param("guid") String guid, @Param("uidList") List<String> uidList, @Param("folderIdList") List<Integer> folderIdList);
}