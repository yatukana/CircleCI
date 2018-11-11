package com.example.logic;

import com.example.model.Event;

import java.util.List;

public interface EventLogic {

	Event createEvent(String guid, String uid);

	List<Event> getEvents(String guid, List<String> uidList, List<Integer> folderIdList);

	Event getEvent(String guid, String uid, Integer folderId);
}
