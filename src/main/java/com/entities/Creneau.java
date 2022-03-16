package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDateTime date_heure;
    private int duree;
    private Type typeCreneau;
    @ManyToOne
    private Cours lecours;
    @OneToMany
    private List<Seance> lesSeances;
}
