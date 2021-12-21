package com.example.planningpoker.controllers;

import com.example.planningpoker.DTOs.MemberDTO;
import com.example.planningpoker.DTOs.SessionPlanningDTO;
import com.example.planningpoker.services.MemberService;
import com.example.planningpoker.services.SessionPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/v1/sessions")
public class SessionPlanningController {

    @Autowired
    private SessionPlanningService service;

    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createNewSession(UriComponentsBuilder b, @RequestBody SessionPlanningDTO dto) {
        UriComponents uriComponents = b.path("/sessions/{id}").buildAndExpand(service.createNewSession(dto).getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @RequestMapping(path = "/{sessionId/members}", method = RequestMethod.GET)
    public ResponseEntity joinInSession(@RequestBody MemberDTO dto, UriComponentsBuilder b) {
        return new ResponseEntity(memberService.joinInSession(dto), HttpStatus.OK);
    }

    @RequestMapping(path = "/destroy-session/{sessionId}", method = RequestMethod.GET)
    public ResponseEntity destroySession(@PathVariable String id) {
        service.destroySession(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
