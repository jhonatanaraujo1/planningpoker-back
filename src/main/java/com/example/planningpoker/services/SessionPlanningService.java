package com.example.planningpoker.services;

import com.example.planningpoker.DTOs.SessionPlanningDTO;
import com.example.planningpoker.entities.SessionPlanning;
import com.example.planningpoker.enums.SessionStatusEnum;
import com.example.planningpoker.factory.Factory;
import com.example.planningpoker.factory.FactorySessionPlanningBySessionPlanningDTO;
import com.example.planningpoker.repositories.SessionPlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionPlanningService {

    @Autowired
    private SessionPlanningRepository repository;

    @Autowired
    private Factory factory;

    public SessionPlanningService(Factory factory) {
        this.factory = new FactorySessionPlanningBySessionPlanningDTO();
    }

    public SessionPlanningDTO createNewSession(SessionPlanningDTO dto) {
        SessionPlanning sessionPlanning = repository.save((SessionPlanning) this.factory.factory(dto));
        dto.setId(sessionPlanning.getId());
        return dto;
    }

    public SessionPlanning findSessionPlanningBySessionId(String id) {
        return repository.findSessionPlanningBySessionId(id);
    }

    public void destroySession(String id) {
        SessionPlanning sessionPlanning = repository.findSessionPlanningBySessionId(id);
        sessionPlanning.setStatus(SessionStatusEnum.CLOSED);
        repository.save((sessionPlanning));
    }
}
