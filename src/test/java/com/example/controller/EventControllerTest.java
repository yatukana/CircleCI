package com.example.controller;

import com.example.model.Event;
import com.example.service.EventService;
import org.easymock.EasyMock;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEvent_正常系() throws Exception {
        // 返却値の設定
        Event event = new Event();
        String uid = "event001";
        String guid = "user1";
        String summary = "summary";
        Integer folderId = 100;
        event.setUid(uid);
        event.setSummary(summary);
        event.setGuid(guid);
        event.setFolderId(folderId);
        // 実行コントローラ
        EventController eventController = new EventController();
        // 実行サービス
        EventService eventServiceMock = EasyMock.createMock(EventService.class);
        // サービスのMockによる返却
        EasyMock.expect(eventServiceMock.getEvent(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class), EasyMock.anyObject(Integer.class))).andReturn(event);
        // コントローラにMock内容を設定
        eventController.eventService = eventServiceMock;
        // 記録した内容をを再生
        EasyMock.replay(eventServiceMock);
        // mock内容のbuild
        this.mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();

        // 実行と返却値の確認
        this.mockMvc.perform(get("/event/" + uid + "/?guid=" + guid + "&folder_id=" + folderId))
                .andExpect(jsonPath("uid").value("event001"))
                .andExpect(jsonPath("guid").value("user1"))
                .andExpect(jsonPath("summary").value("summary"))
                .andExpect(jsonPath("folderId").value(10));
        // mockしたサービスが呼び出されているか確認
        EasyMock.verify(eventServiceMock);

    }

}
