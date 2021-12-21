package com.example.planningpoker.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(targetEntity = Vote.class, mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;

    @ManyToOne()
    @JoinColumn(name = "session_id", insertable = false, updatable = false)
    private SessionPlanning sessionPlanning;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SessionPlanning getSessionPlanning() {
        return sessionPlanning;
    }

    public void setSessionPlanning(SessionPlanning sessionPlanning) {
        this.sessionPlanning = sessionPlanning;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
