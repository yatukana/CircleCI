package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.EventEntity;

@Mapper
public interface EventDao {

	public EventEntity selectByUid(String guid, String uid, Integer folderId);

	public List<EventEntity> selectEventList(String guid, List<String> uidList, List<Integer> folderIdList);
}