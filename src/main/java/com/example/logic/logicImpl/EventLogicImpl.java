package com.example.logic.logicImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.EventEntity;
import com.example.logic.EventLogic;
import com.example.mapper.EventDao;
import com.example.model.Event;

@Component
public class EventLogicImpl implements EventLogic {

	@Autowired
	EventDao eventDao;

	@Override
	public Event createEvent(String guid, String uid) {
		// TODO 自動生成されたメソッド・スタブ
		Event event = new Event();
		event.setGuid("guidは" + guid + ",uidは");
		event.setUid(uid);
		return event;
	}

	@Override
	public List<Event> getEvents(String guid, List<String> uidList, List<Integer> folderIdList) {
		
		// TODO 自動生成されたメソッド・スタブ
		List<EventEntity> eventEntityList = eventDao.selectEventList(guid, uidList, folderIdList);
		List<Event> eventList = new ArrayList<>();
		for (EventEntity entity : eventEntityList) {
			Event event = new Event();
			event.toEvent(entity);
			eventList.add(event);
		}
		return eventList;
	}

	@Override
	public Event getEvent(String guid, String uid, Integer folderId) {
		// TODO 自動生成されたメソッド・スタブ
		EventEntity eventEntity = eventDao.selectByUid(guid, uid, folderId);
		Event event = new Event();
		event.toEvent(eventEntity);
		return event;
	}

}
