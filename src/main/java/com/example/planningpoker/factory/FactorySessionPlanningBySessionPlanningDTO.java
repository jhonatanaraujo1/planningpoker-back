package com.example.planningpoker.factory;

import com.example.planningpoker.DTOs.SessionPlanningDTO;
import com.example.planningpoker.entities.DeckType;
import com.example.planningpoker.entities.SessionPlanning;
import com.example.planningpoker.enums.SessionStatusEnum;
import com.example.planningpoker.exceptions.BadRequestException;
import com.example.planningpoker.services.DeckTypeService;
import com.example.planningpoker.utils.UtilsSession;
import com.example.planningpoker.utils.UtilsSessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FactorySessionPlanningBySessionPlanningDTO implements Factory {

    private static final String SESSION_PLANNING_IS_EMPTY = "Session planning is null or empty";

    @Autowired
    private DeckTypeService deckTypeService;

    @Override
    public Object factory(Object obj) {
        SessionPlanningDTO dto = (SessionPlanningDTO) obj;

        if (Objects.isNull(dto)) {
            throw new BadRequestException(SESSION_PLANNING_IS_EMPTY);
        }

        SessionPlanning sessionPlanning = new SessionPlanning();
        sessionPlanning.setTitle(dto.getTitle());
        sessionPlanning.setStatus(SessionStatusEnum.OPENED);
        sessionPlanning.setDeckType(findDeckTypeById(dto.getDeckId()));

        UtilsSession utils = new UtilsSessionImpl();

        sessionPlanning.setSessionId(utils.generateHash(sessionPlanning.getTitle()));
        return sessionPlanning;
    }

    private DeckType findDeckTypeById(long deckId) {
        return deckTypeService.findDeckTypeById(deckId);
    }
}
