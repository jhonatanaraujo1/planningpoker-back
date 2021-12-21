package com.example.planningpoker.services;

import com.example.planningpoker.DTOs.MemberDTO;
import com.example.planningpoker.entities.Member;
import com.example.planningpoker.exceptions.NotFoundException;
import com.example.planningpoker.factory.Factory;
import com.example.planningpoker.factory.FactoryMemberByMemberDTO;
import com.example.planningpoker.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private static final String MEMBER_NOT_FOUND = "Member not found";
    @Autowired
    MemberRepository repository;
    @Autowired
    private Factory factory;

    public MemberService(Factory factory) {
        this.factory = new FactoryMemberByMemberDTO();
    }

    public Member joinInSession(MemberDTO dto) {
        Member member = repository.save((Member) this.factory.factory(dto));
        return member;
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }

    public Member findMemberById(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(MEMBER_NOT_FOUND));
    }

    public void deleteMember(long id) {
        repository.deleteById(id);
    }


}
