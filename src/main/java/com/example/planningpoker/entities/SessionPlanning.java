package com.example.planningpoker.entities;

import com.example.planningpoker.enums.SessionStatusEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sessions")
public class SessionPlanning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deck_id")
    private DeckType deckType;

    private SessionStatusEnum status;

    @Column(name = "session_hash")
    private String sessionId;

    @OneToMany(targetEntity = Member.class, mappedBy = "sessionPlanning", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DeckType getDeckType() {
        return deckType;
    }

    public void setDeckType(DeckType deckType) {
        this.deckType = deckType;
    }

    public SessionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SessionStatusEnum status) {
        this.status = status;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
