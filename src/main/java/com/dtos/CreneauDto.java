package com.dtos;

import com.entities.Cours;
import com.entities.Seance;
import com.entities.Type;
import lombok.Data;

import java.util.List;


@Data
public class CreneauDto {

    private Long Id;
    private int duree;
    private Type typeCreneau;
    private Cours lecours;
    private List<Seance> lesSeances;
}
