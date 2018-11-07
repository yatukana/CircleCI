package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Event;
import com.example.service.EventService;

@RestController
public class EventController {

	@Autowired
	EventService eventService;

	@RequestMapping(value = { "/event/{uid}" }, method = RequestMethod.GET)
	public Event getEvent(@PathVariable String uid, @RequestParam(value = "guid", required = false) String guid,
			@RequestParam(value = "folder_id", required = false) Integer folderId) {
		Event eventList = eventService.getEvent(uid, guid, folderId);
		return eventList;
	}

	@RequestMapping(value = { "/events/" }, method = RequestMethod.GET)
	public List<Event> getEvents(@RequestParam(value = "uids", required = false) String uids,
			@RequestParam(value = "guid", required = false) String guid,
			@RequestParam(value = "folderids", required = false) String folderIds) {

		List<String> uidList = new ArrayList<>();
		if (uids != null) {
			String[] arrayUid = uids.split(",", 0);
			for (String s : arrayUid) {
				uidList.add(s);
			}
		}

		System.out.println("uidList:" + uidList);
		List<Integer> folderIdList = new ArrayList<>();
		if (folderIds != null) {
			String[] arrayFolderId = folderIds.split(",", 0);
			for (String s : arrayFolderId) {
				folderIdList.add(Integer.parseInt(s));
			}
		}

		System.out.println("folderIdList:" + folderIdList);
		List<Event> eventList = eventService.getEvents(guid, uidList, folderIdList);
		return eventList;
	}

}
