package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Filiere {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String codeFiliereLangue;
    private  String nomFiliereLangue;
    @OneToMany
    private List<Cours> lesCours;
}
