package com.kryha.timetrack.service;

import com.kryha.timetrack.models.DailyStatistics;
import com.kryha.timetrack.payload.response.DailyStatisticResponse;
import com.kryha.timetrack.payload.response.UserResponse;
import com.kryha.timetrack.repository.DailyStatisticsRepository;
import com.kryha.timetrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class DailyStatisticsService {

    @Autowired
    private DailyStatisticsRepository dailyStatisticsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityService activityService;


    public List<UserResponse> getUsersStatisticsByName(String name) {

        List<DailyStatistics> dailyStatistics = getDailyStatistics(name);
        List<UserResponse> userResponseList = new ArrayList<>();

        for (DailyStatistics daily : dailyStatistics) {
            userResponseList.add(
                    new UserResponse(daily
                             .getActivity()
                            .getName(), daily
                            .getTime(), daily
                            .getDate().toString()));
        }

        return userResponseList;
    }


    private List<DailyStatistics> getDailyStatistics(String name) {

           return userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + name))
                .getDailyStatistics();




    }

    public void save(DailyStatisticResponse dailyStatisticResponse) {
        DailyStatistics dailyStatistics = new DailyStatistics();
        dailyStatistics.setActivity(activityService
                        .getActivityByName(dailyStatisticResponse
                        .getNameActivity()));

        dailyStatistics.setTime(dailyStatisticResponse.getTime());

        dailyStatistics.setUser_id(userRepository
                        .findByUsername(dailyStatisticResponse.getNameUser())
                        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + dailyStatisticResponse.getNameUser()))
                        .getId());

        dailyStatistics.setDate(new Date(new java.util.Date().getTime()));

        dailyStatisticsRepository.save(dailyStatistics);
    }

}
