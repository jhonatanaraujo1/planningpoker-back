package com.example.planningpoker.controllers;

import com.example.planningpoker.DTOs.MemberDTO;
import com.example.planningpoker.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/v1/sessions/vote")
public class VoteController {

    @Autowired
    private VoteService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createVote(UriComponentsBuilder b, @RequestBody MemberDTO member) {
        try {
            service.create(member);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok(null);
    }
}
