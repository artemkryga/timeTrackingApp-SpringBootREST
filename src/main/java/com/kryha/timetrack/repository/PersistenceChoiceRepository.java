package com.kryha.timetrack.repository;

import com.kryha.timetrack.models.PersistenceChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersistenceChoiceRepository extends JpaRepository<PersistenceChoice, Integer> {


}
