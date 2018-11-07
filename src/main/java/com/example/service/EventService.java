package com.example.service;

import java.util.List;

import com.example.entity.EventEntity;
import com.example.model.Event;


public interface EventService {
	
	List<Event> getEvents(String guid,List<String> uidList, List<Integer> folderIdList);
	
	Event getEvent(String uid, String guid, Integer folderId);
}
