package com.kryha.timetrack.repository;

import com.kryha.timetrack.models.DailyStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyStatisticsRepository extends JpaRepository<DailyStatistics, Integer> {


}
