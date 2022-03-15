package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String intitule;
    @OneToMany
    private List<Vacataire> lesVacataires;
    @OneToMany
    private List<Creneau> lesCreneaux;
    @OneToMany
    private List<Filiere> lesFilieres;
}
