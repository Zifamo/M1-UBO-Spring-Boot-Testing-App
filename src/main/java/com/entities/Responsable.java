package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Responsable extends Utilisateur {


    @ManyToOne
    private Composante maComposante;

}
