package com.kryha.timetrack.repository;

import com.kryha.timetrack.models.ERole;
import com.kryha.timetrack.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
