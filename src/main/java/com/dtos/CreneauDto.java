package com.dtos;

import com.entities.Cours;
import com.entities.Type;
import lombok.Data;


@Data
public class CreneauDto {

    private Long Id;
    private int duree;
    private Type typeCreneau;
    private Cours lecours;
}
