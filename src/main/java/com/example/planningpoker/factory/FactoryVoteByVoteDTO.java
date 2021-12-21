package com.example.planningpoker.factory;

import com.example.planningpoker.DTOs.MemberDTO;
import com.example.planningpoker.entities.Vote;
import com.example.planningpoker.exceptions.BadRequestException;
import com.example.planningpoker.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FactoryVoteByVoteDTO implements Factory {
    private static final String VOTE_IS_EMPTY = "Vote is null or empty";
    @Autowired
    MemberService memberService;

    @Override
    public Object factory(Object obj) {
        MemberDTO dto = (MemberDTO) obj;

        if (Objects.isNull(dto)) {
            throw new BadRequestException(VOTE_IS_EMPTY);
        }

        Vote vote = new Vote();
        vote.setVote(dto.getVote().getVote());
        vote.setStatus(dto.getVote().getStatus());
        vote.setMember(memberService.findMemberById(dto.getId()));
        return vote;
    }

}
