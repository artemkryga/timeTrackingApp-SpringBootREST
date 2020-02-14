package com.kryha.springjwt.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersistenceResponse {
    private String nameAct;

    private EUserAction action;

    public PersistenceResponse(String nameAct, EUserAction action) {
        this.nameAct = nameAct;
        this.action = action;
    }
}
