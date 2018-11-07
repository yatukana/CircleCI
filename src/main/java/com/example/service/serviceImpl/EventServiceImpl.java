package com.example.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.entity.EventEntity;
import com.example.logic.EventLogic;
import com.example.mapper.EventDao;
import com.example.model.Event;
import com.example.service.EventService;

@Component
public class EventServiceImpl implements EventService {

	@Autowired
	EventLogic eventLogic;

	@Override
	public List<Event> getEvents(String guid, List<String> uidList, List<Integer> folderIdList) {
		// TODO 自動生成されたメソッド・スタブ
		return eventLogic.getEvents(guid, uidList, folderIdList);
	}

	@Override
	public Event getEvent(String uid, String guid, Integer folderId) {
		return eventLogic.getEvent(guid, uid, folderId);
	}

}
