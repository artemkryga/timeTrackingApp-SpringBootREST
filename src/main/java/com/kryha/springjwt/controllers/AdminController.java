package com.kryha.springjwt.controllers;

import com.kryha.springjwt.payload.request.AdminRequest;
import com.kryha.springjwt.payload.response.ActivityResponse;
import com.kryha.springjwt.payload.response.AllUserPersistenceResponse;
import com.kryha.springjwt.service.ActivityService;
import com.kryha.springjwt.service.DailyStatisticsService;
import com.kryha.springjwt.service.PersistenceChoiceService;
import com.kryha.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AdminController {
    @Autowired
    private DailyStatisticsService dailyStatisticsService;

    @Autowired
    private UserService userService;


    @Autowired
    private PersistenceChoiceService persistenceChoiceService;


    @RequestMapping(value = "/getUserActForAdmin", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ActivityResponse> getUserStat(@RequestBody AdminRequest request) {
        return userService.getUserActivitiesResponseByName(request.getNameUser());
    }

    @GetMapping(value = "/getUserPerActivity") //
    public List<AllUserPersistenceResponse> getUserPerActivity() {
        return persistenceChoiceService.getAllUserChoice();
    }

}
