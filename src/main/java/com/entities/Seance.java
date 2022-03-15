package com.entities;

import javax.persistence.*;

@Entity
public class Seance {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private boolean estEffectue;
    private int dureeEffective;
    private boolean valide;
    private String commentaire;
    @ManyToOne
    private Creneau creneauSeance;
}
