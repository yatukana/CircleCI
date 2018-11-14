package com.example.model;


import com.example.entity.FortuneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fortune {

    private String wordOne;

    private String wordTwo;

    private String wordThree;

    @JsonIgnore
    public void toEvent(FortuneEntity entity) {
        this.setWordOne(entity.getWordOne());
        this.setWordTwo(entity.getWordTwo());
        this.setWordThree(entity.getWordThree());
    }

}
