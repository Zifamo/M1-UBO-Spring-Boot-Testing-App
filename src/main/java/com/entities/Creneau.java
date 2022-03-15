package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date date_heure;
    private int duree;
    private Type typeCreneau;
    @ManyToOne
    private Cours lecours;
}
