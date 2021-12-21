package com.example.planningpoker.services;

import com.example.planningpoker.DTOs.MemberDTO;
import com.example.planningpoker.entities.Vote;
import com.example.planningpoker.factory.Factory;
import com.example.planningpoker.factory.FactoryVoteByVoteDTO;
import com.example.planningpoker.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class VoteService {

    @Autowired
    VoteRepository repository;

    @Autowired
    private Factory factory;

    public VoteService(Factory factory) {
        this.factory = new FactoryVoteByVoteDTO();
    }

    public Vote create(MemberDTO dto) {
        return repository.save((Vote) this.factory.factory(dto));
    }

    public Vote findLastVote(long id) {
       return  repository.findVoteByDate(id);
    }
}
