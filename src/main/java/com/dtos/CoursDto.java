package com.dtos;

import com.entities.Creneau;
import com.entities.Filiere;
import com.entities.Vacataire;
import lombok.Data;

import java.util.List;


@Data
public class CoursDto {

    private Long Id;
    private String intitule;
    private List<Vacataire> lesVacataires;
    private List<Creneau> lesCreneaux;
    private List<Filiere> lesFilieres;
}
