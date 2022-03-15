package com.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Vacataire extends Utilisateur {

    @OneToMany(mappedBy = "effectue")
    private List<Seance> lesSeances;

    @ManyToOne
    private Cours leCours;
}
