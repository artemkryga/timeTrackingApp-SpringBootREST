package com.kryha.timetrack.controllers;

import com.kryha.timetrack.payload.request.HomeRequest;
import com.kryha.timetrack.payload.response.ActivityResponse;
import com.kryha.timetrack.payload.request.AdminActionRequest;
import com.kryha.timetrack.payload.response.AllUserPersistenceResponse;
import com.kryha.timetrack.payload.response.EUserAction;
import com.kryha.timetrack.service.PersistenceChoiceService;
import com.kryha.timetrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersistenceChoiceService persistenceChoiceService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/getUserActForAdmin",
                    method = RequestMethod.POST,
                    produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<ActivityResponse> getUserStat(@RequestBody HomeRequest request) {
        return userService.getUserActivitiesResponseByName(request.getUserName());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/getUserPerActivity")
    public List<AllUserPersistenceResponse> getUserPerActivity() {
        return persistenceChoiceService.getAllUserChoice();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/addUserActForAdmin",
                    method = RequestMethod.POST,
                    produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<AllUserPersistenceResponse> adminAction(@RequestBody AdminActionRequest request) {

        if (request.getAgree()) {
            if (request.getAction().equals(EUserAction.ADD.toString()))
                userService.addActivityToUser(request);
            else if (request.getAction().equals(EUserAction.DELETE.toString()))
                userService.deleteActivityToUser(request);
        } else
            persistenceChoiceService.deletePerChoice(request.getId());
        return persistenceChoiceService.getAllUserChoice();
    }

}
