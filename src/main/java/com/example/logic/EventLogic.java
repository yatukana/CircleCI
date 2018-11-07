package com.example.logic;

import java.util.List;

import com.example.model.Event;

public interface EventLogic {

	Event createEvent(String guid, String uid);
	
	List<Event> getEvents(String guid,List<String> uidList, List<Integer> folderIdList);
	
	Event getEvent(String guid ,String uid , Integer folderId);
}
