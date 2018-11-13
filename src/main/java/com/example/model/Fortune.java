package com.example.model;


import com.example.entity.FortuneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Fortune {

    private String uid;

    private String guid;

    private String summary;

    private Integer folderId;

    @JsonIgnore
    public void toEvent(FortuneEntity entity) {
        this.setUid(entity.getUid());
        this.setFolderId(entity.getFolderId());
        this.setSummary(entity.getSummary());
    }

}
