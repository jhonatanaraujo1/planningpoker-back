package com.example.planningpoker.entities;

import javax.persistence.*;

@Entity
@Table(name = "decks")
public class DeckType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToOne(mappedBy = "deckType")
    private SessionPlanning sessionPlanning;
}
