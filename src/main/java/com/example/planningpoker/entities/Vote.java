package com.example.planningpoker.entities;

import com.example.planningpoker.enums.VoteStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String vote;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    private VoteStatusEnum status;

    private Date dateTimeFormat = new Date(System.currentTimeMillis());

    public long getId() {
        return id;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public VoteStatusEnum getStatus() {
        return status;
    }

    public void setStatus(VoteStatusEnum status) {
        this.status = status;
    }

    public Date getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(Date dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }
}
