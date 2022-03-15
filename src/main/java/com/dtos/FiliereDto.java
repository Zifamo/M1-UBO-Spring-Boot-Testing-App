package com.dtos;

import com.entities.Cours;
import lombok.Data;

import java.util.List;


@Data
public class FiliereDto {

    private Long Id;
    private String codeFiliereLangue;
    private  String nomFiliereLangue;
    private List<Cours> lesCours;
}
