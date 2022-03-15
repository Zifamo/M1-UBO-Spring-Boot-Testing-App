package com.dtos;

import com.entities.Utilisateur;
import lombok.Data;

import java.util.List;

@Data
public class VacataireDto extends Utilisateur {

    private List<SeanceDto> lesSeances;
    private CoursDto leCours;
}
