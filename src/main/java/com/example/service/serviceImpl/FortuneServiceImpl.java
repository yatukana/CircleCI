package com.example.service.serviceImpl;

import com.example.logic.FortuneLogic;
import com.example.model.Fortune;
import com.example.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

    @Autowired
    FortuneLogic fortuneLogic;

    @Override
    public Fortune getFortune() {
        return fortuneLogic.getFortune();
    }

}
