package com.example.logic.logicImpl;

import com.example.logic.FortuneLogic;
import com.example.mapper.FortuneDao;
import com.example.model.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FortuneLogicImpl implements FortuneLogic {

    @Autowired
    FortuneDao fortuneDao;

    @Override
    public Fortune getFortune() {

//		FortuneEntity fortuneEntity = fortuneDao.select();
//		Fortune fortune = new Fortune();
//		fortune.toEvent(fortuneEntity);
//		return fortune;
        return new Fortune();
    }

}
