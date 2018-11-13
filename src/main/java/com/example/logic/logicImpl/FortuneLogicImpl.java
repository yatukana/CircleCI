package com.example.logic.logicImpl;

import com.example.entity.FortuneEntity;
import com.example.logic.FortuneLogic;
import com.example.mapper.FortuneDao;
import com.example.model.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FortuneLogicImpl implements FortuneLogic {

    @Autowired
    FortuneDao fortuneDao;

    @Override
    public Fortune getFortune() {

        Integer id1 = fortuneDao.selectOneNumAll();
        Random rnd1 = new Random();
        //乱数を取得する
        int rndId1 = rnd1.nextInt(id1) + 1;

        Integer id2 = fortuneDao.selectTwoNumAll();
        Random rnd2 = new Random();
        //乱数を取得する
        int rndId2 = rnd2.nextInt(id2) + 1;


        Integer id3 = fortuneDao.selectThreeNumAll();
        Random rnd3 = new Random();
        //乱数を取得する
        int rndId3 = rnd3.nextInt(id3) + 1;


        String wordOne = fortuneDao.selectOneByNum(rndId1);

        String wordTwo = fortuneDao.selectTwoByNum(rndId2);

        String wordThree = fortuneDao.selectThreeByNum(rndId3);
        Fortune fortune = new Fortune();
        fortune.setWordOne(wordOne);
        fortune.setWordTwo(wordTwo);
        fortune.setWordThree(wordThree);
        return fortune;
    }

}
