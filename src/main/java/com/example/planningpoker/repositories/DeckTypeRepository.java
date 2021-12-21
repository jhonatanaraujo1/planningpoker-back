package com.example.planningpoker.repositories;

import com.example.planningpoker.entities.DeckType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckTypeRepository extends JpaRepository<DeckType, Long> {
}
