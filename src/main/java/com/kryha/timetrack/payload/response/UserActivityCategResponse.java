package com.kryha.timetrack.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class UserActivityCategResponse {
    private List<ActivityResponse> activities;

    private String nameCategory;

    public UserActivityCategResponse(String nameCategory, List<ActivityResponse> activities) {
        this.activities = activities;
        this.nameCategory = nameCategory;
    }
}
