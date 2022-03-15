package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Vacataire extends Utilisateur {

    @OneToMany
    private List<Seance> lesSeances;

    @ManyToOne
    private Cours leCours;
}
