package com.example.model;


import com.example.entity.EventEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Event {

    private String uid;

    private String guid;

    private String summary;

    private Integer folderId;

    @JsonIgnore
    public void toEvent(EventEntity entity) {
        this.setUid(entity.getUid());
        this.setFolderId(entity.getFolderId());
        this.setSummary(entity.getSummary());
    }

}
