package com.example.planningpoker.factory;

import com.example.planningpoker.DTOs.MemberDTO;
import com.example.planningpoker.entities.Member;
import com.example.planningpoker.exceptions.BadRequestException;
import com.example.planningpoker.services.MemberService;

import com.example.planningpoker.services.SessionPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FactoryMemberByMemberDTO implements Factory {

    private static final String MEMBER_IS_EMPTY = "Member is null or empty";

    @Autowired
    private MemberService memberService;
    @Autowired
    private SessionPlanningService sessionPlanningService;
    @Autowired
    private Factory factory;

    @Override
    public Object factory(Object obj) {
        MemberDTO dto = (MemberDTO) obj;
        if (Objects.isNull(dto)) {
            throw new BadRequestException(MEMBER_IS_EMPTY);
        }
        Member member = new Member();
        member.setName(dto.getName());
        member.setSessionPlanning(sessionPlanningService.findSessionPlanningBySessionId(dto.getSessionId()));
        return member;
    }
}
