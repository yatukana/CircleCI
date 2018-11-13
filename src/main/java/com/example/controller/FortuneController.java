package com.example.controller;

import com.example.model.Event;
import com.example.model.Fortune;
import com.example.service.EventService;
import com.example.service.FortuneService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@MapperScan("com.example.mapper")
public class FortuneController {

    @Autowired
    FortuneService fortuneService;

    @RequestMapping(value = {"/fortune/"}, method = RequestMethod.GET)
    public Fortune getEvent(@RequestParam(value = "word-one", required = false) String wordOne,
                            @RequestParam(value = "word-two", required = false) String wordTwo,
                            @RequestParam(value = "word-three", required = false) String wordThree) {
        Fortune fortuneList = fortuneService.getFortune();
        return fortuneList;
    }


}
