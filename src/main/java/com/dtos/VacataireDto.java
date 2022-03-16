package com.dtos;

import com.entities.Cours;
import com.entities.Seance;
import lombok.Data;

import java.util.List;

@Data
public class VacataireDto extends UtilisateurDto {

    private List<Seance> lesSeances;
    private Cours leCours;
}
