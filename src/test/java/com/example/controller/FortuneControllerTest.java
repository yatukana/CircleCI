package com.example.controller;

import com.example.model.Fortune;
import com.example.service.FortuneService;
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
public class FortuneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFortune_正常系() throws Exception {
        // 返却値の設定
        Fortune fortune = new Fortune();
        String wordOne = "1";
        String wordTwo = "2";
        String wordThree = "3";
        fortune.setWordOne(wordOne);
        fortune.setWordTwo(wordTwo);
        fortune.setWordThree(wordThree);
        // 実行コントローラ
        FortuneController fortuneController = new FortuneController();
        // 実行サービス
        FortuneService fortuneServiceMock = EasyMock.createMock(FortuneService.class);
        // サービスのMockによる返却
        EasyMock.expect(fortuneServiceMock.getFortune()).andReturn(fortune);
        // コントローラにMock内容を設定
        fortuneController.fortuneService = fortuneServiceMock;
        // 記録した内容をを再生
        EasyMock.replay(fortuneServiceMock);
        // mock内容のbuild
        this.mockMvc = MockMvcBuilders.standaloneSetup(fortuneController).build();

        // 実行と返却値の確認
        this.mockMvc.perform(get("/fortune/"))
                .andExpect(jsonPath("wordOne").value("2"))
                .andExpect(jsonPath("wordTwo").value("2"))
                .andExpect(jsonPath("wordThree").value("3"));
        // mockしたサービスが呼び出されているか確認
        EasyMock.verify(fortuneServiceMock);

    }

}
