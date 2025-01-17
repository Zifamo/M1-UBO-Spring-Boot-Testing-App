package com.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date date_heure;
    private int duree;
    private Type typeCreneau;
    @ManyToOne
    private Cours lecours;
    @OneToMany
    private List<Seance> lesSeances;
}
