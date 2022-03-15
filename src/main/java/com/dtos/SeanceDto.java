package com.dtos;

import com.entities.Creneau;
import lombok.Data;

@Data
public class SeanceDto {

    private Long Id;
    private boolean estEffectue;
    private int dureeEffective;
    private boolean valide;
    private String commentaire;
    private Creneau creneauSeance;
}
