package com.example.planningpoker.repositories;

import com.example.planningpoker.entities.SessionPlanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionPlanningRepository extends JpaRepository<SessionPlanning, Long> {

    SessionPlanning findSessionPlanningBySessionId(String id);
}
