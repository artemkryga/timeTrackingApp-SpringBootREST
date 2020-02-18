package com.kryha.timetrack.repository;

import com.kryha.timetrack.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Activity getActivitiesByName(String name);

}
