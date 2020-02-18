package com.kryha.timetrack.service;


import com.kryha.timetrack.models.Activity;
import com.kryha.timetrack.payload.response.ActivityResponse;
import com.kryha.timetrack.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity getActivityByName(String name) {
        return activityRepository.getActivitiesByName(name);
    }

    public List<ActivityResponse> getAllActivity() {
        List<Activity> listAct = activityRepository.findAll();
        List<ActivityResponse> listActResponse = new ArrayList<>();
        for (Activity a :
                listAct) {
            listActResponse.add(new ActivityResponse(
                    a.getName(), a.getCategory().getName()));
        }
        return listActResponse;
    }

}
