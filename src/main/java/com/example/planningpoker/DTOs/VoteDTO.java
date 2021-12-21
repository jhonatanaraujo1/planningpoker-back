package com.example.planningpoker.DTOs;

import com.example.planningpoker.entities.Member;
import com.example.planningpoker.enums.VoteStatusEnum;

public class VoteDTO {

    private long id;

    private String vote;

    private Member memberId;

    private VoteStatusEnum status;

    public long getId() {
        return id;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public VoteStatusEnum getStatus() {
        return status;
    }

    public void setStatus(VoteStatusEnum status) {
        this.status = status;
    }
}
