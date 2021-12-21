package com.example.planningpoker.services;

import com.example.planningpoker.entities.DeckType;
import com.example.planningpoker.exceptions.NotFoundException;
import com.example.planningpoker.repositories.DeckTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckTypeService {

    private static final String DECKTYPE_NOT_FOUND = "Decktype not found";
    @Autowired
    DeckTypeRepository repository;

    public DeckType findDeckTypeById(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(DECKTYPE_NOT_FOUND));
    }

}
