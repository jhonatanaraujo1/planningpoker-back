package com.example.planningpoker.repositories;

import com.example.planningpoker.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.lang.annotation.Native;
import java.util.Date;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query(value = "select * from vote where member_id = ? order by dateTimeFormat desc limit 1",nativeQuery = true)
    Vote findVoteByDate(long id);
}
